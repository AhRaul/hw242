public class MeteoStation{
    public static void main(String[] args){
        MeteoStore meteoDb = new MeteoStore();

        MeteoSensor ms200_1 = new MS200(1);
        meteoDb.save(ms200_1);

        MeteoSensor ms500Info = new ST500InfoAdapter(new ST500Info());
        meteoDb.save(ms500Info);
        // Здесь надо вызвать метод getData у класса ST500Info. Полученные данные отправить в метод save объекта meteoDb
    }
}