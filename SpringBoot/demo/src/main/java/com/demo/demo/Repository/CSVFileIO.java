package com.demo.demo.Repository;


import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.demo.demo.Entity.*;
import com.opencsv.CSVReader;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

@Repository
public class CSVFileIO {
    public List<FileEntity> read() throws FileNotFoundException{
        
        List<FileEntity> list = new ArrayList<>();
        try {
            CSVReader read=new CSVReader(new FileReader("src/main/resources/data.csv"));
            String[] line;

            while((line=read.readNext())!=null){
                FileEntity fileEntity = new FileEntity();
                fileEntity.setId(line[0]);
                fileEntity.setConcept(line[1]);
                fileEntity.setSubject(line[2]);
                fileEntity.setData1(line[3]);
                fileEntity.setData2(line[4]);
                fileEntity.setData3(line[5]);
                fileEntity.setData4(line[6]);
                fileEntity.setData5(line[7]);
                fileEntity.setData6(line[8]);
                fileEntity.setData7(line[9]);
                fileEntity.setData8(line[10]);

                list.add(fileEntity);
                
            }
        } catch (Exception e) {
        }
        
       return list;
    }

    public List<SampleEntity> readSample(){
         
        try{
            CsvToBean<SampleEntity> csvToBean = new CsvToBeanBuilder<SampleEntity>(new FileReader("src/main/resources/sample.csv"))
                .withType(SampleEntity.class)   // map to your class
                .withIgnoreLeadingWhiteSpace(true)
                .build();
            List<SampleEntity> records = csvToBean.parse();

            for (SampleEntity record : records) {
            System.out.println(record);
            }
            return records;
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }        
    }
    
}
