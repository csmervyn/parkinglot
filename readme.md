# parking lot
停车：
1、Given 用户来停车，When 停车场有位置，Then 停车成功，并给用户一个凭证；
2、Give 用户来停车，When 停车场没有可用的位置，Then 停车失败；

取车：
3、Give 用户拿凭证来取车，When 停车场有与该凭证所对应的车，Then 用户取车成功，将车返还用户，销毁凭证；
4、Give 用户拿凭证来取车，When 停车场没有与该凭证所对应的车，Then 用户取车失败；
5、Give 用户拿取过的凭证来取车，When 停车场已经没有与该凭证所对应的车，Then 用户取车失败；
# graduate parking boy
停车：
1、Given 用户来停车，When Boy停车场A有位置，Then 将车停在A停车场，停车成功，并给用户一个凭证；
2、Given 用户来停车，When Boy停车场A没有位置，B停车场有位置，Then 将车停在B停车场，停车成功，并给用户一个凭证；

3、Give 用户来停车，When 停车场A和B都没有可用的位置，Then 停车失败；

取车：
4、Give 用户拿凭证来取车，When A或B停车场有与该凭证所对应的车，Then 用户取车成功，将车返还用户，销毁凭证；
5、Give 用户拿凭证来取车，When A或B停车场没有与该凭证所对应的车，Then 用户取车失败；
6、Give 用户拿已经使用过的凭证来取车，When A或B停车场已经没有与该凭证所对应的车，Then 用户取车失败；

# smart parking boy
停车（其中A、B为泛指）：
1、Given 用户来停车，When Boy停车场A有位置，停车场B也有位置，A停车场的空位比B停车场空位多，Then 将车停在A停车场，停车成功，并给用户一个凭证；
2、Given 用户来停车，When Boy停车场A有位置，停车场B也有位置，B停车场的空位比A停车场空位多，Then 将车停在B停车场，停车成功，并给用户一个凭证；
3、Given 用户来停车，When Boy停车场A有位置，停车场B也有位置，B停车场的空位数等于A停车场空位数，Then 将车停在A停车场，停车成功，并给用户一个凭证；
4、Give 用户来停车，When 停车场A和B都没有可用的位置，Then 停车失败；

取车：
5、Give 用户拿凭证来取车，When A或B停车场有与该凭证所对应的车，Then 用户取车成功，将车返还用户，销毁凭证；
6、Give 用户拿凭证来取车，When A或B停车场没有与该凭证所对应的车，Then 用户取车失败；
7、Give 用户拿已经使用过的凭证来取车，When A或B停车场已经没有与该凭证所对应的车，Then 用户取车失败；

# super parking boy
停车（其中A、B为泛指）：
1、Given 用户来停车，When Boy A停车场的空置率比B停车场的空置率高，Then 将车停在A停车场，停车成功，并给用户一个凭证；
2、Given 用户来停车，When Boy B停车场的空置率比A停车场的空置率高，Then 将车停在B停车场，停车成功，并给用户一个凭证；
3、Given 用户来停车，When Boy B停车场的空置率等于A停车场的空置率，并且空置率未到达0%，Then 将车停在A停车场，停车成功，并给用户一个凭证；
4、Give 用户来停车，When 停车场A和B的空置率均到达0%，Then 停车失败；

取车：
5、Give 用户拿凭证来取车，When A或B停车场有与该凭证所对应的车，Then 用户取车成功，将车返还用户，销毁凭证；
6、Give 用户拿凭证来取车，When A或B停车场没有与该凭证所对应的车，Then 用户取车失败；
7、Give 用户拿已经使用过的凭证来取车，When A或B停车场已经没有与该凭证所对应的车，Then 用户取车失败；

# parking Manager
停车
1、Given 用户来停车，When Parking Manager 找到Graduate Parking Boy来停车，停车场有位置 Then Graduate Parking Boy停车成功，并给用户一个凭证；
2、Given 用户来停车，When Parking Manager 找到Graduate Parking Boy来停车，停车场没有位置 Then Graduate Parking Boy停车失败；

3、Given 用户来停车，When Parking Manager 找到Smart Parking Boy来停车，停车场有位置 Then Smart Parking Boy停车成功，并给用户一个凭证；
4、Given 用户来停车，When Parking Manager 找到Smart Parking Boy来停车，停车场没有位置 Then Smart Parking Boy停车失败；

5、Given 用户来停车，When Parking Manager 找到Super Parking Boy来停车，停车场有位置 Then Super Parking Boy停车成功，并给用户一个凭证；
6、Given 用户来停车，When Parking Manager 找到Super Parking Boy来停车，停车场没有位置 Then Super Parking Boy停车失败；

7、Given 用户来停车，When Parking Manager 自己来停车，停车场有位置 Then Parking Manager停车成功，并给用户一个凭证；
8、Given 用户来停车，When Parking Manager 自己来停车，停车场没有位置 Then Parking Manager停车失败；

取车
1、Give 用户拿凭证来取车，When 停车场有与该凭证所对应的车，Then 用户取车成功，将车返还用户，销毁凭证；
2、Give 用户拿凭证来取车，When 停车场没有与该凭证所对应的车，Then 用户取车失败；
3、Give 用户拿已经使用过的凭证来取车，When 车场已经没有与该凭证所对应的车，Then 用户取车失败；

