package org.dell.kube.pages;
import ch.qos.logback.classic.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pages")
public class PageController {
    Logger logger =(Logger) LoggerFactory.getLogger(this.getClass());
    private IPageRepository pageRepository;
    public PageController(IPageRepository pageRepository)
    {
        this.pageRepository = pageRepository;
    }
    @PostMapping
    public ResponseEntity<Page> create(@RequestBody Page page) {
        logger.info("CREATE-INFO:Creating a new page");
        logger.debug("CREATE-DEBUG:Creating a new  page");
        Page newPage= pageRepository.create(page);
        logger.info("CREATE-INFO:Created a new page with id = " + newPage.id);
        logger.debug("CREATE-DEBUG:Created a new  page with id = " + newPage.id);
        return new ResponseEntity<Page>(newPage, HttpStatus.CREATED);
    }
    @GetMapping("{id}")
    public ResponseEntity<Page> read(@PathVariable long id) {
        logger.info("READ-INFO:Fetching page with id = " + id);
        logger.debug("READ-DEBUG:Fetching page with id = " + id);
        Page page = pageRepository.read(id);
        if(page!=null)
            return new ResponseEntity<Page>(page, HttpStatus.OK);
        else {
            logger.error("READ-ERROR:Could not find page with id = " + id);
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping
    public ResponseEntity<List<Page>> list() {
        logger.info("LIST-INFO:Fetching all pages");
        logger.debug("LIST-DEBUG:Fetching all pages");
        List<Page> pages= pageRepository.list();
        return new ResponseEntity<List<Page>>(pages, HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<Page> update(@RequestBody Page page, @PathVariable long id) {
        logger.info("UPDATE-INFO:Updating the page with id = " + id);
        logger.debug("UPDATE-DEBUG:Updating the page with id = " + id);
        Page updatedPage= pageRepository.update(page,id);
        if(updatedPage!=null)
            return new ResponseEntity<Page>(updatedPage, HttpStatus.OK);
        else {
            logger.error("UPDATE-ERROR:Could not update the page with id = " + id);
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping("{id}")
    public ResponseEntity delete(@PathVariable long id) {
        logger.info("DELETE-INFO:Deleting the page with id = " + id);
        logger.debug("DELETE-DEBUG:Deleting the page with id = " + id);
        pageRepository.delete(id);
        logger.info("DELETE-INFO:Deleted the page with id = " + id);
        logger.debug("DELETE-DEBUG:Deleted the page with id = " + id);

        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}