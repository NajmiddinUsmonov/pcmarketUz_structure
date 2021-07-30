package uz.usmonov.pcmarketuz.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.usmonov.pcmarketuz.entity.Attachment;
import uz.usmonov.pcmarketuz.entity.AttachmentContent;

import java.util.Optional;

public interface AttachmentContentRepository extends JpaRepository<AttachmentContent,Integer> {

    Optional<AttachmentContent> findAttachmentContentByAttachment_Id(Integer id);
    boolean existsAttachmentContentByAttachment_Id(Integer id);
    AttachmentContent getAttachmentContentByAttachment_Id(Integer id);
}
