//package com.dongxiang.dongxiang.controller;
//
//import com.dongxiang.dongxiang.domain.UserManageEntity;
//import com.dongxiang.dongxiang.repository.UserRepository;
//import com.microsoft.azure.storage.blob.CloudBlobContainer;
//import org.apache.poi.hssf.usermodel.*;
//import org.springframework.beans.factory.annotation.Autowired;
//
//import java.io.IOException;
//import java.text.SimpleDateFormat;
//import java.util.Date;
//import java.util.List;
//import java.util.UUID;
//
//
//public class ExcelController {
//    @Autowired
//    private UserRepository userRepository;
//
//    /**
//     * 创建表头
//     * @param workbook
//     * @param sheet
//     */
//    private void createTitle(HSSFWorkbook workbook, HSSFSheet sheet) {
//        HSSFRow row = sheet.createRow(0);
//        // 设置列宽, setColumnWidth的第二个参数要乘256, 这个参数的单位是1/256个字符宽度
//        sheet.setColumnWidth(2, 12*256);
//        sheet.setColumnWidth(3, 17*256);
//
//        // 设置为居中加粗
//        HSSFCellStyle style = workbook.createCellStyle();
//        HSSFFont font = workbook.createFont();
//        font.setBold(true);
////        style.setAlignment(ALIGN_CENTER);
//        style.setFont(font);
//
//        HSSFCell cell;
//        cell = row.createCell(0);
//        cell.setCellValue("id");
//        cell.setCellStyle(style);
//
//        cell = row.createCell(1);
//        cell.setCellValue("创建时间");
//        cell.setCellStyle(style);
//
//        cell = row.createCell(2);
//        cell.setCellValue("最后一次修改时间");
//        cell.setCellStyle(style);
//
//        cell = row .createCell(3);
//        cell.setCellValue("用户名");
//        cell.setCellStyle(style);
//
//        cell = row.createCell(4);
//        cell.setCellValue("用户密码");
//        cell.setCellStyle(style);
//
//        cell = row.createCell(5);
//        cell.setCellValue("用户编号");
//        cell.setCellStyle(style);
//
//        cell = row.createCell(6);
//        cell.setCellValue("用户照片路径");
//        cell.setCellStyle(style);
//
//        cell = row.createCell(7);
//        cell.setCellValue("用户真实姓名");
//        cell.setCellStyle(style);
//
//        cell = row.createCell(8);
//        cell.setCellValue("用户具体地址");
//        cell.setCellStyle(style);
//
//        cell = row.createCell(9);
//        cell.setCellValue("用户电话号码");
//        cell.setCellStyle(style);
//
//        cell = row.createCell(10);
//        cell.setCellValue("用户备注");
//        cell.setCellStyle(style);
//    }
//
//    public Object getExcel() throws IOException {
//        HSSFWorkbook workbook = new HSSFWorkbook();
//        HSSFSheet sheet = workbook.createSheet("用户表");
//        createTitle(workbook, sheet);
//
//        List<UserManageEntity> userManageEntities = userRepository.findAll();
//
//        // 新增数据行, 并且设置单元格数据
//        int rowNum = 1;
//        for (UserManageEntity userManageEntity : userManageEntities) {
//            HSSFRow row = sheet.createRow(rowNum);
//            row.createCell(0).setCellValue(userManageEntity.getId());
//            row.createCell(1).setCellValue(userManageEntity.getGmtCreate());
//            row.createCell(2).setCellValue(userManageEntity.getGmtModified());
//
//            row.createCell(3).setCellValue(userManageEntity.getPkUserid());
//            row.createCell(4).setCellValue(userManageEntity.getUserPwd());
//
//            row.createCell(5).setCellValue(userManageEntity.getUserNum());
//            row.createCell(6).setCellValue(userManageEntity.getUserPic());
//            row.createCell(7).setCellValue(userManageEntity.getUserRealname());
//            row.createCell(8).setCellValue(userManageEntity.getUserLocation());
//            row.createCell(9).setCellValue(userManageEntity.getUserTelephone());
//            row.createCell(10).setCellValue(userManageEntity.getUserRemark());
//            rowNum++;
//        }
//        // 拼装blobName
//        String filename = "用户表.xlsx";
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
//        String dateTime = simpleDateFormat.format(new Date());
//        String blobTime = dateTime + "/" + UUID.randomUUID().toString().replaceAll("-", "") + filename;
//
//        // 获取或者创建container
////        CloudBlobContainer blobContainer =
//
//        //
//    }
//}
