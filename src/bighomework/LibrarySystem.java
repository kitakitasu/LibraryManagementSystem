//        序列化和反序列化知识点的展现
        try{
            File file=new File("D:\\Java\\readersMap.dat");
            FileOutputStream fos=new FileOutputStream(file);
            ObjectOutputStream oos=new ObjectOutputStream(fos);
            oos.writeObject(readersMap);
            oos.flush();
            oos.close();
            fos.close();

        }catch (Exception e){
            e.printStackTrace();
        }

        try{
            File file=new File("D:\\Java\\readersMap.dat");
            FileInputStream fis=new FileInputStream(file);
            ObjectInputStream iis=new ObjectInputStream(fis);
            readersMap= (Map<String, readers>) iis.readObject();
//            System.out.println(readersMap);
            iis.close();
            fis.close();
        }catch (Exception e){
            e.printStackTrace();
        }
