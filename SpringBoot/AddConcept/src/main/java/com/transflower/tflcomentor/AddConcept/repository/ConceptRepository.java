package com.transflower.tflcomentor.AddConcept.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.DriverManager;
import java.util.List;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import com.transflower.tflcomentor.AddConcept.entity.FrameworkConcept;
import com.transflower.tflcomentor.AddConcept.entity.Concept;
import com.transflower.tflcomentor.AddConcept.entity.Framework;

@Repository
public class ConceptRepository {

    private static Connection connection;
    private FrameworkConcept frameworkConcept=new FrameworkConcept();
    
    @Value("${spring.datasource.url}")
    private static String url;

    @Value("${spring.datasource.password}")
    private static String password;

    @Value("${spring.datasource.username}")
    private static String username;

    public ConceptRepository() {
    }

    static{
        try {
            connection = DriverManager.getConnection(url, username, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public boolean addConcept(Concept concept){
        String query="INSERT INTO concepts(name,description,status) VALUE(?,?,?)";
        try{    
            PreparedStatement ps=connection.prepareStatement(query);
            ps.setString(1,concept.getName());
            ps.setString(2,concept.getDescription());
            ps.setInt(3,concept.getStatus());

            ps.executeQuery();

            ResultSet rs=ps.getGeneratedKeys();

            if(rs.next()){
                int generatedId=rs.getInt(1);
                concept.setId(generatedId);
                frameworkConcept.setConceptId(generatedId);
            }
            return true;
        }
        catch(Exception e){
            e.printStackTrace();
            return false;
        } 
    }

    public Concept getConceptDetails(String conceptName){
        String query="SELECT id, name, description, status FROM concepts WHERE name=?";
        try{
            PreparedStatement ps=connection.prepareStatement(query);
            ps.setString(1, conceptName);
            
            ResultSet rs=ps.executeQuery();
            
            if(rs.next()){
                Concept concept=new Concept();
                concept.setId(rs.getInt("id"));
                concept.setName(rs.getString("name"));
                concept.setDescription(rs.getString("description"));
                concept.setStatus(rs.getInt("status"));
                return concept;
            }
            return null;
        }
        catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }


    public List<Framework> getFramework(int languageId, int layerId){
        String query="SELECT * FROM frameworks WHERE language_id=? AND layer_id=?";
        List<Framework> frameworks=new ArrayList<>();
        try{
            PreparedStatement ps=connection.prepareStatement(query);
            ps.setInt(1, languageId);
            ps.setInt(2, layerId);
            
            ResultSet rs=ps.executeQuery();
            
            while(rs.next()){
                Framework framework=new Framework();
                framework.setId(rs.getInt("id"));
                framework.setLanguageId(rs.getInt("language_id"));
                framework.setLayerId(rs.getInt("layer_id"));
                framework.setName(rs.getString("name"));
                frameworks.add(framework);
            }
            return frameworks;
        }
        catch(Exception e){
            e.printStackTrace();
            return frameworks;
        }
    }

    public boolean addConceptFrameworkMapping(int frameworkId, int conceptId){
        String query="INSERT INTO framework_concepts(framework_id, concept_id) VALUES(?, ?)";
        try{
            PreparedStatement ps=connection.prepareStatement(query);
            ps.setInt(1, frameworkId);
            ps.setInt(2, conceptId);
            
            int rowsAffected=ps.executeUpdate();
            
            if(rowsAffected > 0){
                return true;
            }
            return false;
        }
        catch(Exception e){
            e.printStackTrace();
            return false;
        }
    }

}
    



