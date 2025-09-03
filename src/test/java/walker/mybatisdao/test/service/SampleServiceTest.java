package walker.mybatisdao.test.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import walker.mybatisdaoj.test.Application;
import walker.mybatisdaoj.test.service.SampleService;


@SpringBootTest(classes = Application.class)
public class SampleServiceTest {

    @Autowired
    private SampleService sampleService; // 直接注入


    @BeforeEach
    public void testSave() {
        sampleService.deleteAll();

        sampleService.saveOne();
        sampleService.saveMany();
        sampleService.findAll();
    }

    @Test
    public void testUpdate() {
        sampleService.updateOne();
        sampleService.findAll();

        sampleService.updateMany();
        sampleService.findAll();
    }

    @Test
    public void testDelete() {
        sampleService.deleteOne();
        sampleService.findAll();

        sampleService.deleleteMany();
        sampleService.findAll();
    }


    @Test
    public void testCommonQuery() {
        sampleService.findOne();
        sampleService.findByPks();
    }


    @Test
    public void testPagerQuery() {
        sampleService.findBooks();
        sampleService.findByPrice();
    }


    @Test
    public void testJoinQuery() {
        sampleService.saveEditorAndRelation();
        sampleService.findEditorAndBook();
    }

}