package com.aysevarlik.springboothomework.database.dao;

import com.aysevarlik.springboothomework.database.dto.CvDto;
import lombok.extern.log4j.Log4j2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

@Log4j2
public class cvDao implements daoConnection<CvDto>{

    @Override
    public void create(CvDto cvDto) {
        try (Connection connection = getInterfaceConnection()) {
            String sql = "insert into product(name,surname,mail,message) values(?,?,?,?)";
            PreparedStatement preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setString(1, cvDto.getName());
            preparedStatement.setString(2,cvDto.getSurname());
            preparedStatement.setString(3, String.valueOf(cvDto.getMail()));
            preparedStatement.setString(4, String.valueOf(cvDto.getMessage()));
            int rowEffected=  preparedStatement.executeUpdate();
            if(rowEffected>0){
                log.info("Ekleme Başarılı");
            }else{
                log.info("Ekleme Başarısız...");
            }

        } catch (Exception e) {
            log.info(cvDao.class + "  Ekleme sırasında hata meydana geldi");
            e.printStackTrace();
        }

    }

    @Override
    public void update(CvDto cvDto) {
        try (Connection connection = getInterfaceConnection()) {
            String sql = "update product set name=?,surname=?,mail=?,message=? where id=?";
            PreparedStatement preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setString(1,cvDto.getName());
            preparedStatement.setString(2,cvDto.getSurname());
            preparedStatement.setString(3, cvDto.getMail());
            preparedStatement.setString(4, cvDto.getMessage());
            preparedStatement.setLong(5, cvDto.getID());
            int rowEffected=  preparedStatement.executeUpdate();
            if(rowEffected>0){
                log.info("Güncelleme Başarılı");
            }else{
                log.info("Güncelleme Başarısız");
            }

        } catch (Exception e) {
            log.error(CvDto.class + "  Ekleme sırasında hata meydana geldi");
            e.printStackTrace();
        }

    }

    @Override
    public void delete(CvDto cvDto) {
        try (Connection connection = getInterfaceConnection()) {
            String sql = "delete from product where id=?";
            PreparedStatement preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setLong(1,cvDto.getID());
            int rowEffected=  preparedStatement.executeUpdate();
            if(rowEffected>0){
                log.info("Silme Başarılı");
            }else{
                log.info("Silme Başarısız");
            }
        } catch (Exception e) {
            log.info(CvDto.class + "  Silme sırasında hata meydana geldi");
            e.printStackTrace();
        }

    }

    @Override
    public ArrayList<CvDto> list() {
        ArrayList<CvDto> list1=new ArrayList<>();
        CvDto cvDto;
        try (Connection connection = getInterfaceConnection()) {
            String sql = "select * from product";
            PreparedStatement preparedStatement=connection.prepareStatement(sql);
            ResultSet resultSet= preparedStatement.executeQuery();
            while(resultSet.next()){
                cvDto=new CvDto();
                cvDto.setID(resultSet.getInt("id"));
                cvDto.setName(resultSet.getString("name"));
                cvDto.setSurname(resultSet.getString("surname"));
                cvDto.setMail(resultSet.getString("mail"));
                cvDto.setMessage(resultSet.getString("message"));
                cvDto.setCreatedDate(resultSet.getDate("created date"));
                list1.add(cvDto);
            }
        } catch (Exception e) {
            log.info(CvDto.class + "  Silme sırasında hata meydana geldi");
            e.printStackTrace();
        }
        return list1;
    }
}
