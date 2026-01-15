package com.demo.demo.Service;

import com.demo.demo.Entity.*;
import com.demo.demo.Repository.*;

import java.io.FileNotFoundException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CSVFileIOService{
    @Autowired
    CSVFileIO repo;

    public List<FileEntity> read() throws FileNotFoundException{
        System.out.println("hiiiiiiiiiiiiiiiiii");
        return repo.read();
    }
}