package com.example.shoppingmall.controller;

import com.example.shoppingmall.domain.Beer;
import com.example.shoppingmall.domain.Category;
import com.example.shoppingmall.domain.ImageFile;
import com.example.shoppingmall.service.Impl.BeerServiceImpl;
import com.example.shoppingmall.service.Impl.CategoryServiceImpl;
import com.example.shoppingmall.service.Impl.ImageFileServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.Calendar;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/beers")
@RequiredArgsConstructor
public class BeerController {
    private final CategoryServiceImpl categoryServiceImpl;
    private final BeerServiceImpl beerServiceImpl;
    private final ImageFileServiceImpl imageFileServiceImpl;

    @GetMapping("/beer")
    public String beer(
//            @PathVariable(name = "id") Long id,
//            Model model
    ){
//        Beer beer = beerServiceImpl.getBeer(id);
//        model.addAttribute("beer",beer);
        return "beers/beer";
    }


    @GetMapping("/images/{id}")
    @ResponseBody
    public void downloadImage(
            @PathVariable(name = "id") Long id,
            HttpServletResponse response
    ) {
        ImageFile imageFile = imageFileServiceImpl.getImageFile(id);
        response.setContentType(imageFile.getMimeType());

        try (FileInputStream fis = new FileInputStream(imageFile.getSaveFileName());
             OutputStream out = response.getOutputStream()
        ) {
            byte[] buffer = new byte[1024];
            int readCount = 0;

            while ((readCount = fis.read(buffer)) != -1) {
                out.write(buffer, 0, readCount);
            }
        } catch (Exception ex) {
            ex.printStackTrace();

        }
    }

    @GetMapping("/add")
    public String addform(Model model){
        List<Category> categories = categoryServiceImpl.getAll();
        model.addAttribute("categories", categories);
        return "admin/addform";
    }

    @PostMapping("/add")
    public String add(
            @RequestParam(name = "name") String name,
            @RequestParam(name = "price") long price,
            @RequestParam(name = "amount") long amount,
            @RequestParam(name = "categoryId") long categoryId,
            @RequestParam(name = "image") MultipartFile[] images
    ) {
//        SecurityUser securityUser =
//                (SecurityUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        Beer beer = new Beer();
        beer.setName(name);
        beer.setAmount(amount);
        beer.setPrice(price); //Todo image파일, name price amount categoryId 를 받는 html만들기

        if (images != null && images.length > 0) {
            for (MultipartFile image : images) {
                ImageFile imageFile = new ImageFile();
                imageFile.setLength(image.getSize());
                imageFile.setMimeType(image.getContentType());
                imageFile.setName(image.getOriginalFilename());

                String saveFileName = saveFile(image);

                imageFile.setSaveFileName(saveFileName);
                beer.addImageFile(imageFile);
            }
        }
        beerServiceImpl.addBeer(beer, categoryId);
        return "redirect:/main";
    }


    private String saveFile(MultipartFile image) {
        String dir = "/tmp/";
        Calendar calendar = Calendar.getInstance();
        dir = dir + calendar.get(Calendar.YEAR);
        dir = dir + "/";
        dir = dir + (calendar.get(Calendar.MONTH) + 1);//calander에서 month는 처음에 0으로 시작한다.
        dir = dir + "/";
        dir = dir + (calendar.get(Calendar.DAY_OF_MONTH));
        dir = dir + "/";
        File dirFile = new File(dir);
        dirFile.mkdirs();
        dir = dir + UUID.randomUUID().toString();

        try(
            FileOutputStream fos = new FileOutputStream(dir);
            InputStream in = image.getInputStream();
        ){
            byte[] buffer = new byte[1024];
            int readCount = 0;
            while((readCount = in.read(buffer)) != -1){
                fos.write(buffer, 0, readCount);
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }

        return  dir;

    }
}

