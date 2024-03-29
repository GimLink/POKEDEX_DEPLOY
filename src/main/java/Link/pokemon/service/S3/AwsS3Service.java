package Link.pokemon.service.S3;

import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.PutObjectRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.UUID;

@Service
@Slf4j
@RequiredArgsConstructor
public class AwsS3Service {

    private final AmazonS3Client amazonS3Client;

    @Value("${cloud.aws.s3.bucket}")
    String bucket;

    public String upload(MultipartFile uploadFile, String fileName) throws IOException {
        return putS3(uploadFile, fileName);
    }

    private String putS3(MultipartFile uploadFile, String fileName) throws IOException {
        amazonS3Client
                .putObject(new PutObjectRequest(bucket, fileName, uploadFile.getInputStream(), null));
        return amazonS3Client.getUrl(bucket, fileName).toString();
    }

    // 이미지 가져오기
    public String getS3FileUrl(String filePath){
        return amazonS3Client.getUrl(bucket, filePath).toString();
    }

    // UUID로 고유한 이미지 이름 생성
    public String createFileName(String fileName){
        return UUID.randomUUID().toString().substring(0, 13) + "_" + fileName;
    }
}
