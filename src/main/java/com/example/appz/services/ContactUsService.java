package com.example.appz.services;

import com.example.appz.models.ContactUs;
import com.example.appz.models.User;
import com.example.appz.repositories.ContactUsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ContactUsService {
    private final ContactUsRepository contactUsRepository;

    public List<ContactUs> getAll(int page, int size) {
        Pageable paging = PageRequest.of(page, size);
        var contactsUs = contactUsRepository.findAll(paging);
        return contactsUs.toList();
    }

    public Optional<ContactUs> getById(int id) {
        return contactUsRepository.findById(id);
    }

    public ContactUs save(ContactUs contactUs) {
        return contactUsRepository.save(contactUs);
    }

    public Optional<ContactUs> delete(int id) {
        var contactUs = this.getById(id);
        contactUsRepository.deleteById(id);
        return contactUs;
    }
}
