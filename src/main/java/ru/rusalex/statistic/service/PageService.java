package ru.rusalex.statistic.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.rusalex.statistic.model.Page;
import ru.rusalex.statistic.repository.PageRepository;

@Service
public class PageService {

    @Autowired
    PageRepository pageRepository;

    @Transactional
    public Page getOrCreatePage(String pageAddress) {
        if (pageAddress==null) throw new IllegalArgumentException("pageAddress cannot be empty");
        Page page = pageRepository.findByAddress(pageAddress);
        if (page == null) {
            page = new Page(pageAddress);
            pageRepository.save(page);
        }
        return page;
    }


}
