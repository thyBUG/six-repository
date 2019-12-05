package com.aaa.lee.app.controller;

import com.aaa.lee.app.base.BaseController;

import com.aaa.lee.app.service.CommentService;
import com.aaa.lee.app.service.MemberService;
import com.aaa.lee.app.service.UploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


@RestController
public class PhotoController extends BaseController {

   @Autowired
    private CommentService commentService;

   @Autowired
   private UploadService uploadService;



    /***
     * 上传图片
     * @param file
     * @param request
     * @param orderCommentVo
     * @param commentReplayService
     * @return
     */
    @PostMapping(value = "/uploadHead",produces = {MediaType.APPLICATION_JSON_UTF8_VALUE},consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public String uploadHead(@RequestPart MultipartFile file){
        System.out.println( "provider层"+file.getOriginalFilename());
        return uploadService.uploadHead(file);

       }

    /***
     * 多文件上传
     */
    @PostMapping(value = "/upload",headers = "content-type=multipart/form-data")
    public String upload(@RequestPart(value = "file") MultipartFile[] file) {
            String path="";
            String paths="";
            System.out.println(file.length);

          for (MultipartFile fina : file) {
            System.out.println("provider层" + fina.getOriginalFilename());
            path= uploadService.uploadHead(fina);
            path=path+";";
            paths+=path;
        }
        System.out.println("================"+paths);
        return paths;
    }


}
