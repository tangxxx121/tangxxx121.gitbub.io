package homework01.LostandFound;

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        //分别创建两个书类失物和卡类失物
        CardLost c1 = new CardLost();
        CardLost c2 = new CardLost();
        BookLost b1 = new BookLost();
        BookLost b2 = new BookLost();
        String Pos_f;//用户输入的领取地点
        //
        Lost[] lostArray01 = {c1, c2, b1, b2};//存入系统的信息
        Lost[] lostarray = {};//返还给用户的信息
//登记失物信息
        c1.Pos_Lost = "the third teaching building";
        c1.Num = "2021213104";
        c1.College = "The College of Computer Science";
        c1.Time_Lost = 7017;
        c1.name = "Jack 's card";
        c1.Pos_Found = "Lost Property Office";

        c2.Pos_Lost = "the second teaching building";
        c2.Num = "2021213105";
        c2.College = "The College of Computer Science";
        c2.Time_Lost = 7018;
        c2.name = "Tom 's card";
        c2.Pos_Found = "Lost Property Office";

        b1.Pos_Lost = "the second teaching building";
        b1.name = "Math";
        b1.Time_Lost = 6018;
        b1.Pos_Found = "Lost Property Office";

        b2.Pos_Lost = "the fourth teaching building";
        b2.Time_Lost = 6030;
        b2.name = "English";
        b2.Pos_Found = "the second teaching building";
        //用户提示
        Scanner input = new Scanner(System.in);
        System.out.println("please input the location to collect your lost items");
        Pos_f = input.nextLine();//键盘输入领取地点
        System.out.println("=========is searching=========");
        lostarray = selectByKeyword(lostArray01, Pos_f);
        for (int i = 0; i < lostarray.length; i++) {
            System.out.println(lostarray[i].name);
        }
    }
    /**
     * 失物排序方法
     * @param lostArray1 待排序的失物数组
     */
    public static void sortLost(Lost[] lostArray1){
        Lost temp;
        //冒泡排序
        for (int i = 0; i < lostArray1.length - 1; i++) {
            for (int j = 0; j < lostArray1.length - 1 - i; j++) {
                if (lostArray1[j].Time_Lost < lostArray1[j + 1].Time_Lost) {
                    temp = lostArray1[j];
                    lostArray1[j] = lostArray1[j + 1];
                    lostArray1[j + 1] = temp;
                }
            }
        }
    }

    /**
     * 按关键字搜索失物的方法，这里假设按照失物的领取地点进行搜索
     * @param lostArray 失物数组
     * @param keyword 用户输入的关键字
     * @return 返回查找到的失物
     */
    public static Lost[] selectByKeyword(Lost[] lostArray, String keyword){
        Lost[] lost_return = new Lost[4];
        sortLost(lostArray);
        for (int i = 0, j = 0; i < lostArray.length; i++) {
            if (lostArray[i].Pos_Found.equals(keyword)) {
                lost_return[j] = lostArray[i];
                j++;
            }
        }
        return lost_return;

    }
}
