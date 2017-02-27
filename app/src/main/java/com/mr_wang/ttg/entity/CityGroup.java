package com.mr_wang.ttg.entity;

import java.util.List;

/**
 * Created by MR_Wang on 2017/2/26.
 */

public class CityGroup {
    /**
     * state : 1
     * dtates : [{"city_id":4,"city_name":"淮北","city_sortkey":"H"},{"city_id":19,"city_name":"阜阳","city_sortkey":"F"},{"city_id":22,"city_name":"蚌埠","city_sortkey":"B"},{"city_id":25,"city_name":"淮南","city_sortkey":"H"},{"city_id":32,"city_name":"滁州","city_sortkey":"C"},{"city_id":39,"city_name":"巢湖","city_sortkey":"C"},{"city_id":40,"city_name":"合肥","city_sortkey":"H"},{"city_id":43,"city_name":"马鞍山","city_sortkey":"M"},{"city_id":48,"city_name":"芜湖","city_sortkey":"W"},{"city_id":51,"city_name":"宣城","city_sortkey":"X"},{"city_id":54,"city_name":"桐城","city_sortkey":"T"},{"city_id":61,"city_name":"铜陵","city_sortkey":"T"},{"city_id":65,"city_name":"池州","city_sortkey":"C"},{"city_id":68,"city_name":"安庆","city_sortkey":"A"},{"city_id":69,"city_name":"黄山","city_sortkey":"H"},{"city_id":171,"city_name":"福州","city_sortkey":"F"},{"city_id":183,"city_name":"莆田","city_sortkey":"P"},{"city_id":185,"city_name":"龙岩","city_sortkey":"L"},{"city_id":191,"city_name":"泉州","city_sortkey":"Q"},{"city_id":196,"city_name":"厦门","city_sortkey":"X"},{"city_id":197,"city_name":"晋江","city_sortkey":"J"},{"city_id":199,"city_name":"石狮","city_sortkey":"S"},{"city_id":200,"city_name":"漳州","city_sortkey":"Z"},{"city_id":242,"city_name":"兰州","city_sortkey":"L"},{"city_id":307,"city_name":"清远","city_sortkey":"Q"},{"city_id":311,"city_name":"花都","city_sortkey":"H"},{"city_id":322,"city_name":"东莞","city_sortkey":"D"},{"city_id":324,"city_name":"阳江","city_sortkey":"Y"},{"city_id":353,"city_name":"汕头","city_sortkey":"S"},{"city_id":354,"city_name":"佛山","city_sortkey":"F"},{"city_id":358,"city_name":"惠州","city_sortkey":"H"},{"city_id":372,"city_name":"深圳","city_sortkey":"S"},{"city_id":374,"city_name":"江门","city_sortkey":"J"},{"city_id":375,"city_name":"中山","city_sortkey":"Z"},{"city_id":386,"city_name":"茂名","city_sortkey":"M"},{"city_id":389,"city_name":"湛江","city_sortkey":"Z"},{"city_id":392,"city_name":"珠海","city_sortkey":"Z"},{"city_id":407,"city_name":"桂林","city_sortkey":"G"},{"city_id":427,"city_name":"柳州","city_sortkey":"L"},{"city_id":462,"city_name":"南宁","city_sortkey":"N"},{"city_id":465,"city_name":"玉林","city_sortkey":"Y"},{"city_id":475,"city_name":"北海","city_sortkey":"B"},{"city_id":519,"city_name":"贵阳","city_sortkey":"G"},{"city_id":562,"city_name":"海口","city_sortkey":"H"},{"city_id":578,"city_name":"三亚","city_sortkey":"S"},{"city_id":616,"city_name":"秦皇岛","city_sortkey":"Q"},{"city_id":618,"city_name":"唐山","city_sortkey":"T"},{"city_id":628,"city_name":"涿州","city_sortkey":"Z"},{"city_id":649,"city_name":"保定","city_sortkey":"B"},{"city_id":683,"city_name":"石家庄","city_sortkey":"S"},{"city_id":730,"city_name":"邯郸","city_sortkey":"H"},{"city_id":762,"city_name":"齐齐哈尔","city_sortkey":"Q"},{"city_id":781,"city_name":"佳木斯","city_sortkey":"J"},{"city_id":782,"city_name":"大庆","city_sortkey":"D"},{"city_id":795,"city_name":"哈尔滨","city_sortkey":"H"},{"city_id":813,"city_name":"牡丹江","city_sortkey":"M"},{"city_id":820,"city_name":"安阳","city_sortkey":"A"},{"city_id":840,"city_name":"焦作","city_sortkey":"J"},{"city_id":852,"city_name":"郑州","city_sortkey":"Z"},{"city_id":865,"city_name":"洛阳","city_sortkey":"L"},{"city_id":954,"city_name":"襄阳","city_sortkey":"X"},{"city_id":970,"city_name":"宜昌","city_sortkey":"Y"},{"city_id":975,"city_name":"武汉","city_sortkey":"W"},{"city_id":1026,"city_name":"连云港","city_sortkey":"L"},{"city_id":1057,"city_name":"扬州","city_sortkey":"Y"},{"city_id":1059,"city_name":"南京","city_sortkey":"N"},{"city_id":1065,"city_name":"镇江","city_sortkey":"Z"},{"city_id":1071,"city_name":"南通","city_sortkey":"N"},{"city_id":1073,"city_name":"常州","city_sortkey":"C"},{"city_id":1075,"city_name":"江阴","city_sortkey":"J"},{"city_id":1079,"city_name":"无锡","city_sortkey":"W"},{"city_id":1082,"city_name":"苏州","city_sortkey":"S"},{"city_id":1083,"city_name":"昆山","city_sortkey":"K"},{"city_id":1085,"city_name":"徐州","city_sortkey":"X"},{"city_id":1093,"city_name":"九江","city_sortkey":"J"},{"city_id":1102,"city_name":"景德镇","city_sortkey":"J"},{"city_id":1111,"city_name":"南昌","city_sortkey":"N"},{"city_id":1122,"city_name":"上饶","city_sortkey":"S"},{"city_id":1132,"city_name":"抚州","city_sortkey":"F"},{"city_id":1137,"city_name":"宜春","city_sortkey":"Y"},{"city_id":1146,"city_name":"萍乡","city_sortkey":"P"},{"city_id":1155,"city_name":"吉安","city_sortkey":"J"},{"city_id":1170,"city_name":"赣州","city_sortkey":"G"},{"city_id":1200,"city_name":"吉林","city_sortkey":"J"},{"city_id":1202,"city_name":"长春","city_sortkey":"C"},{"city_id":1211,"city_name":"延吉","city_sortkey":"Y"},{"city_id":1242,"city_name":"沈阳","city_sortkey":"S"},{"city_id":1266,"city_name":"盘锦","city_sortkey":"P"},{"city_id":1267,"city_name":"锦州","city_sortkey":"J"},{"city_id":1268,"city_name":"葫芦岛","city_sortkey":"H"},{"city_id":1269,"city_name":"鞍山","city_sortkey":"A"},{"city_id":1288,"city_name":"大连","city_sortkey":"D"},{"city_id":1290,"city_name":"阜新","city_sortkey":"F"},{"city_id":1341,"city_name":"赤峰","city_sortkey":"C"},{"city_id":1365,"city_name":"呼和浩特","city_sortkey":"H"},{"city_id":1372,"city_name":"包头","city_sortkey":"B"},{"city_id":1380,"city_name":"鄂尔多斯","city_sortkey":"E"},{"city_id":1385,"city_name":"石嘴山","city_sortkey":"S"},{"city_id":1388,"city_name":"银川","city_sortkey":"Y"},{"city_id":1393,"city_name":"吴忠","city_sortkey":"W"},{"city_id":1492,"city_name":"宝鸡","city_sortkey":"B"},{"city_id":1494,"city_name":"西安","city_sortkey":"X"},{"city_id":1503,"city_name":"咸阳","city_sortkey":"X"},{"city_id":1553,"city_name":"烟台","city_sortkey":"Y"},{"city_id":1555,"city_name":"威海","city_sortkey":"W"},{"city_id":1574,"city_name":"潍坊","city_sortkey":"W"},{"city_id":1588,"city_name":"淄博","city_sortkey":"Z"},{"city_id":1591,"city_name":"济南","city_sortkey":"J"},{"city_id":1594,"city_name":"聊城","city_sortkey":"L"},{"city_id":1600,"city_name":"莱芜","city_sortkey":"L"},{"city_id":1603,"city_name":"泰安","city_sortkey":"T"},{"city_id":1605,"city_name":"青岛","city_sortkey":"Q"},{"city_id":1629,"city_name":"日照","city_sortkey":"R"},{"city_id":1637,"city_name":"临沂","city_sortkey":"L"},{"city_id":1709,"city_name":"太原","city_sortkey":"T"},{"city_id":1711,"city_name":"晋中","city_sortkey":"J"},{"city_id":1749,"city_name":"临汾","city_sortkey":"L"},{"city_id":1770,"city_name":"运城","city_sortkey":"Y"},{"city_id":1811,"city_name":"绵阳","city_sortkey":"M"},{"city_id":1829,"city_name":"德阳","city_sortkey":"D"},{"city_id":1838,"city_name":"南充","city_sortkey":"N"},{"city_id":1840,"city_name":"成都","city_sortkey":"C"},{"city_id":1883,"city_name":"乐山","city_sortkey":"L"},{"city_id":1904,"city_name":"泸州","city_sortkey":"Z"},{"city_id":1990,"city_name":"乌鲁木齐","city_sortkey":"W"},{"city_id":2179,"city_name":"昆明","city_sortkey":"K"},{"city_id":2249,"city_name":"嘉兴","city_sortkey":"J"},{"city_id":2250,"city_name":"湖州","city_sortkey":"H"},{"city_id":2259,"city_name":"杭州","city_sortkey":"H"},{"city_id":2265,"city_name":"舟山","city_sortkey":"Z"},{"city_id":2266,"city_name":"富阳","city_sortkey":"F"},{"city_id":2267,"city_name":"绍兴","city_sortkey":"S"},{"city_id":2268,"city_name":"宁波","city_sortkey":"N"},{"city_id":2269,"city_name":"桐庐","city_sortkey":"T"},{"city_id":2278,"city_name":"义乌","city_sortkey":"Y"},{"city_id":2282,"city_name":"兰溪","city_sortkey":"L"},{"city_id":2286,"city_name":"金华","city_sortkey":"J"},{"city_id":2343,"city_name":"长沙县","city_sortkey":"C"},{"city_id":2351,"city_name":"长沙","city_sortkey":"C"},{"city_id":2361,"city_name":"株洲","city_sortkey":"Z"},{"city_id":2418,"city_name":"重庆","city_sortkey":"Z"},{"city_id":2419,"city_name":"北京","city_sortkey":"B"},{"city_id":2420,"city_name":"天津","city_sortkey":"T"},{"city_id":2421,"city_name":"上海","city_sortkey":"S"},{"city_id":2422,"city_name":"广州","city_sortkey":"G"},{"city_id":9999,"city_name":"全国","city_sortkey":"Q"},{"city_id":440113,"city_name":"番禺","city_sortkey":"F"},{"city_id":440606,"city_name":"顺德","city_sortkey":"S"},{"city_id":500101,"city_name":"万州","city_sortkey":"W"},{"city_id":623003,"city_name":"泰国","city_sortkey":"T"}]
     * page : 0
     * size : 0
     * count : 0
     */

    private int state;
    private int page;
    private int size;
    private int count;
    private List<City> dtates;

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<City> getDtates() {
        return dtates;
    }

    public void setDtates(List<City> dtates) {
        this.dtates = dtates;
    }
}
