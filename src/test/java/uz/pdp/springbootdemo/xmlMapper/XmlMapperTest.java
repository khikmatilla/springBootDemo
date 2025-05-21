package uz.pdp.springbootdemo.xmlMapper;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.junit.jupiter.api.Test;
import uz.pdp.springbootdemo.objectMapper.Post;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.List;

public class XmlMapperTest {

    @Test
    public void testXmlMapper() throws Exception {
        Post post = new Post();
        post.setUserId(1);
        post.setId(1);
        post.setTitle("Tolov va xizmatlar uchun");
        post.setBody("Ushbu user humo bank kartasidan market xizmatlar uchun pul otkazdi");

        XmlMapper xmlMapper = new XmlMapper();
        xmlMapper.writeValue(new FileOutputStream("data/xml_output.xml"), post);
    }
@Test
    public void testXmlToList() throws Exception {
        Post post = new Post();
        post.setUserId(1);
        post.setId(1);
        post.setTitle("Tolov va xizmatlar uchun");
        post.setBody("Ushbu user humo bank kartasidan market xizmatlar uchun pul otkazdi");

        XmlMapper xmlMapper = new XmlMapper();
        xmlMapper.writeValue(new FileOutputStream("data/xml_output.xml"), List.of(post, post, post));
    }

    @Test
    public void fromXmlToObject() throws Exception {
        XmlMapper xmlMapper = new XmlMapper();
        Post post = xmlMapper.readValue(new FileInputStream("data/xml_output.xml"), Post.class);
        System.out.println(post);
    }

}
