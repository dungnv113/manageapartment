package com.dung.manageapartment.controller;


import com.dung.manageapartment.entity.Apartment;
import com.dung.manageapartment.entity.Resident;
import com.dung.manageapartment.model.ResidentDTO;
import com.dung.manageapartment.service.ApartmentService;
import com.dung.manageapartment.service.ResidentService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Optional;

@Controller
@RequestMapping("/admin/resident")
@RequiredArgsConstructor
public class ResidentController {
    @Autowired
    private ResidentService residentService;

    @Autowired
    private ApartmentService apartmentService;


    //show resident
    @GetMapping()
    public String listResident(Model model) {
        model.addAttribute("residents", residentService.getAll());
        model.addAttribute("products", apartmentService.getAll());
        return "/admin/viewResident.html";
    }

    //add new resident
    @GetMapping("/add")
    public String addResident(Model model) {
        model.addAttribute("resident", new Resident());
        model.addAttribute("listApartments", apartmentService.getAll());
        return "admin/addResident";
    }

//    @PostMapping("/add")
//    public String addResident(@Valid @ModelAttribute("resident") Resident resident, BindingResult result, Model model, @RequestParam("apartmentId") Long apartmentId) {
//        if(apartmentId ==1)
//            model.addAttribute("select",1);
//        return result.hasErrors() ? "/admin/addApartment" : residentService.add(resident, model);
//    }

    @PostMapping("/add")
    public String addResident(@Valid @ModelAttribute("resident") Resident resident, Model model,
                              @RequestParam(name = "file1", required = false) MultipartFile file1,
                              @RequestParam("apartmentId") Long apartmentId,
                              @RequestParam("dateOfBirth") String dateOfBirth,
                              @RequestParam(name = "file2", required = false) MultipartFile file2,
                              BindingResult bindingResult, HttpServletRequest request) {
        Optional<Apartment> apartment = Optional.ofNullable(apartmentService.getById(apartmentId));
        if (apartment.isPresent()){
            resident.setApartment(apartment.get());
        }
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            resident.setDateOfBirth(dateFormat.parse(dateOfBirth));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        if (file1 != null && file1.getSize() > 0) {
            try {
                final String folder = "E:/vmo/manageapartment/picture/upload";
                String originFilename = file1.getOriginalFilename();

                File newFile = new File(folder + "/" + originFilename);

                // copy noi dung file upload vao file new
                file1.transferTo(newFile);

                // luu lai vao db
                resident.setFrontIdCard(originFilename);
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        if (file2 != null && file2.getSize() > 0) {
            try {
                final String folder = "E:/vmo/manageapartment/picture/upload";
                String originFilename2 = file2.getOriginalFilename();

                File newFile2 = new File(folder + "/" + originFilename2);

                // copy noi dung file upload vao file new
                file2.transferTo(newFile2);

                // luu lai vao db
                resident.setBackIdCard(originFilename2);
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        if (apartmentId == 1)
            model.addAttribute("select", 1);
        return bindingResult.hasErrors() ? "/admin/addApartment" : residentService.add(resident, model);
//        return "redirect:/admin/resident";
    }

    @GetMapping("/download1")
    public void download1(@RequestParam(name = "frontIdCard", required = true) String frontIdCard,
                          HttpServletResponse response) {
        final String folder = "E:/vmo/manageapartment/picture/upload";

        File file = new File(folder + "/" + frontIdCard);
        if (file.exists()) {
            try {
                Files.copy(file.toPath(), response.getOutputStream());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @GetMapping("/download2")
    public void download2(@RequestParam("backIdCard") String backIdCard,
                          HttpServletResponse response) {
        final String folder = "E:/vmo/manageapartment/picture/upload";

        File file = new File(folder + "/" + backIdCard);
        if (file.exists()) {
            try {
                Files.copy(file.toPath(), response.getOutputStream());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    //edit resident information
    @GetMapping("/edit/{id}")
    public String update(@PathVariable(name = "id") Long id, Model model) {
        Resident getId = residentService.getById(id);
        if (getId == null) {
            return "/error/notFound";
        }
        model.addAttribute("resident", getId);
        model.addAttribute("listApartments", apartmentService.getAll());
        return "admin/editResident";
    }

    //
    @PostMapping("/edit")
    public String updatePost(@Valid @ModelAttribute("resident") Resident dto, BindingResult result, Model model) {
        return result.hasErrors() ? "edit/Resident" : residentService.edit(dto);
    }

    //
//
    //delete resident
    @GetMapping("/delete/{id}")
    public String deleteResident(@PathVariable("id") Long id, Model model) {
        return residentService.delete(id);
    }
}