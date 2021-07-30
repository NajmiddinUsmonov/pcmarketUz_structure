package uz.usmonov.pcmarketuz.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.usmonov.pcmarketuz.entity.Attachment;

public interface AttachmentRepository extends JpaRepository<Attachment,Integer> {

}
