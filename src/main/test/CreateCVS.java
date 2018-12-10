import org.apache.commons.beanutils.BeanUtils;
import org.springframework.util.Base64Utils;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class CreateCVS {

    @SuppressWarnings("rawtypes")
    public static File createCSVFile(List exportData, LinkedHashMap map, String outPutPath,
                                     String fileName) {
        File csvFile = null;
        BufferedWriter csvFileOutputStream = null;
        try {
            File file = new File(outPutPath);
            if (!file.exists()) {
                file.mkdir();
            }
            //定义文件名格式并创建
            csvFile = File.createTempFile(fileName, ".csv", new File(outPutPath));
            System.out.println("csvFile：" + csvFile);
            System.out.println("csvFileName：" + csvFile.getName());
            // UTF-8使正确读取分隔符","
            csvFileOutputStream = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(
                    csvFile), StandardCharsets.UTF_8), 1024);
            System.out.println("csvFileOutputStream：" + csvFileOutputStream);
            // 写入文件头部
            for (Iterator propertyIterator = map.entrySet().iterator(); propertyIterator.hasNext();) {
                java.util.Map.Entry propertyEntry = (java.util.Map.Entry) propertyIterator.next();
                csvFileOutputStream.write((String) propertyEntry.getValue());
                if (propertyIterator.hasNext()) {
                    csvFileOutputStream.write(",");
                }
            }
            csvFileOutputStream.newLine();
            // 写入文件内容
            for (Iterator iterator = exportData.iterator(); iterator.hasNext();) {
                Object row = (Object) iterator.next();
                for (Iterator propertyIterator = map.entrySet().iterator(); propertyIterator
                        .hasNext();) {
                    java.util.Map.Entry propertyEntry = (java.util.Map.Entry) propertyIterator
                            .next();
                    csvFileOutputStream.write((String) BeanUtils.getProperty(row,
                            (String) propertyEntry.getKey()));
                    if (propertyIterator.hasNext()) {
                        csvFileOutputStream.write(",");
                    }
                }
                if (iterator.hasNext()) {
                    csvFileOutputStream.newLine();
                }
            }
            csvFileOutputStream.flush();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                csvFileOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return csvFile;
    }

    public static void main(String[] args) throws IOException {

        List exportData = new ArrayList<Map>();
        LinkedHashMap map = null;
        Map  row1 =  null;
        for (int i = 0; i < 1 ; i++){
            UUID UID = UUID.randomUUID();
            // 电彩
            String json = "{\n" +
                    "    \"orderId\": \""+UID.toString()+"\",\n" +
                    "    \"payId\": \"4\",\n" +
                    "    \"orderAmount\": \"5.00\",\n" +
                    "    \"remark \": \"\",\n" +
                    "    \"orderGoodsDetail\": [\n" +
                    "        {\n" +
                    "            \"goodsBarcode\": \"D000007\",\n" +
                    "            \"goodsPrice\": \"58\",\n" +
                    "            \"goodsCount\": \"1\",\n" +
                    "            \"vipFlag\": \"0\",\n" +
                    "            \"vipStartDate\": \"\",\n" +
                    "            \"vip_end_date\": \"\"\n" +
                    "        }\n" +
                    "    ]\n" +
                    "}";
            // 即开
            json = "{\n" +
                    "    \"orderId\": \""+UID.toString()+"\",\n" +
                    "    \"orderAmount\": \"0.1\",\n" +
                    "    \"payId\": \"1\",\n" +
                    "    \"orderGoodsDetail\": [\n" +
                    "        {\n" +
                    "            \"goodsBarcode\": \"0002\",\n" +
                    "            \"goodsPrice\": \"0.01\",\n" +
                    "            \"goodsCount\": \"1\",\n" +
                    "            \"vipFlag\": \"0\",\n" +
                    "            \"vipStartDate\": \"\",\n" +
                    "            \"vipEndDate\": \"\",\n" +
                    "            \"wayId\": \"01001\"\n" +
                    "        }\n" +
                    "    ]\n" +
                    "}";

            //String value = new String(Base64.en(json.getBytes()), StandardCharsets.UTF_8);
            String value = new String(Base64Utils.encode(json.getBytes(StandardCharsets.UTF_8)), StandardCharsets.UTF_8);


            map = new LinkedHashMap();
            map.put("1", "G000000000024");
            map.put("2", value);

            row1 = new LinkedHashMap<String, String>();
            row1.put("1", "G000000000024");
            row1.put("2", value);
            System.out.println(value);
            exportData.add(row1);
        }



//        LinkedHashMap map = new LinkedHashMap();
//        map.put("1", "标题1");
//        map.put("2", "标题2");
//
//        List exportData = new ArrayList<Map>();
//        Map row1 = new LinkedHashMap<String, String>();
//        row1.put("1", "11");
//        row1.put("2", "12");
//        row1.put("3", "13");
//        row1.put("4", "14");
//        exportData.add(row1);
//        row1 = new LinkedHashMap<String, String>();
//        row1.put("1", "21");
//        row1.put("2", "22");
//        row1.put("3", "23");
//        row1.put("4", "24");
//        exportData.add(row1);
        String path = "E:/";
        String fileName ="CSV文件生成";
        File file = createCSVFile(exportData, map, path, "param");
        String fileName2 = file.getName();
        System.out.println("文件名称：" + fileName2);

    }
}
