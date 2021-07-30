package uz.usmonov.pcmarketuz.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import uz.usmonov.pcmarketuz.Repository.AttachmentContentRepository;
import uz.usmonov.pcmarketuz.Repository.AttachmentRepository;
import uz.usmonov.pcmarketuz.entity.Attachment;
import uz.usmonov.pcmarketuz.entity.AttachmentContent;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/attachment")
public class AttachmentController {

    @Autowired
    AttachmentRepository attachmentRepository;

    @Autowired
    AttachmentContentRepository attachmentContentRepository;

    @PostMapping
    public HttpEntity<?> add(MultipartHttpServletRequest request) throws IOException {

        Iterator<String> fileNames = request.getFileNames();

        while (fileNames.hasNext()){
            MultipartFile file = request.getFile(fileNames.next());

            if (file==null){
                return ResponseEntity.notFound().build();
            }

            Attachment attachment=new Attachment();
            attachment.setOriginalFileName(file.getOriginalFilename());
            attachment.setContentType(file.getContentType());
            attachment.setSize(file.getSize());
            Attachment attachment1 = attachmentRepository.save(attachment);

            AttachmentContent attachmentContent=new AttachmentContent();
            attachmentContent.setMainContent(file.getBytes());
            attachmentContent.setAttachment(attachment);
        }
        return ResponseEntity.ok().build();
    }

    @GetMapping("/info/{id}")
    public HttpEntity<?> getFileInfo(@PathVariable Integer id){
        Optional<Attachment> attachmentOptional = attachmentRepository.findById(id);
        if (!attachmentOptional.isPresent()){
            return ResponseEntity.notFound().build();
        }
        Attachment attachment = attachmentOptional.get();
        return ResponseEntity.ok(attachment);
    }

    @GetMapping()
    public HttpEntity<?> getAll(){
        List<Attachment> all = attachmentRepository.findAll();
        return ResponseEntity.ok(all);

    }

    @GetMapping("/download/{id}")
    public HttpEntity<?> download(HttpServletResponse response,@PathVariable Integer id) throws IOException {
        Optional<AttachmentContent> contentOptional = attachmentContentRepository.findAttachmentContentByAttachment_Id(id);
        Optional<Attachment> attachmentOptional = attachmentRepository.findById(id);
        if (!attachmentOptional.isPresent())
            return ResponseEntity.notFound().build();

        if (!contentOptional.isPresent())
            return ResponseEntity.notFound().build();

        AttachmentContent attachmentContent = contentOptional.get();
        Attachment attachment = attachmentOptional.get();

        response.setHeader("Content-Disposition","attachment; filename=\""+attachment.getOriginalFileName()+"\"");
        response.setContentType(attachment.getContentType());

        FileCopyUtils.copy(attachmentContent.getMainContent(),response.getOutputStream());
        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }

    public HttpEntity<?> edit(MultipartHttpServletRequest request,@PathVariable Integer id) throws IOException {
        boolean content = attachmentContentRepository.existsAttachmentContentByAttachment_Id(id);
        boolean attachment = attachmentRepository.existsById(id);
            if (!attachment) {
                return ResponseEntity.notFound().eTag("Attachment not found").build();
            }

        if (content) {
            return ResponseEntity.notFound().eTag("Content not found").build();
        }
        Iterator<String> fileNames = request.getFileNames();
        MultipartFile file = request.getFile(fileNames.next());
        Attachment attachment1 = attachmentRepository.getById(id);
        attachment1.setSize(file.getSize());
        attachment1.setContentType(file.getContentType());
        attachment1.setOriginalFileName(file.getOriginalFilename());
        Attachment attachment2 = attachmentRepository.save(attachment1);

        AttachmentContent content1 = attachmentContentRepository.getAttachmentContentByAttachment_Id(id);
        content1.setAttachment(attachment2);
        content1.setMainContent(file.getBytes());
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public HttpEntity<?> delete(@PathVariable Integer id){
        boolean exists = attachmentRepository.existsById(id);
        boolean content = attachmentContentRepository.existsAttachmentContentByAttachment_Id(id);
        if (!exists) {
            return ResponseEntity.notFound().eTag("Attachment not found").build();
        }

        if (content) {
            return ResponseEntity.notFound().eTag("Content not found").build();
        }
            attachmentContentRepository.deleteById(id);
             attachmentRepository.deleteById(id);
             return ResponseEntity.ok().build();
    }



}
