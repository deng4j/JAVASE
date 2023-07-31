package dzh.com.demos.AreaToTree;

import com.alibaba.fastjson.JSON;
import dzh.com.demos.AreaToTree.domain.Area;
import dzh.com.demos.AreaToTree.domain.AreaVo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

public class MainApp {

    private static List<Area> data;

    static {
        data = List.of(
                new Area(1, 0, "湖南"),
                new Area(2, 0, "四川"),
                new Area(3, 0, "湖北"),

                new Area(4, 1, "长沙市"),
                new Area(5, 1, "株洲市"),
                new Area(6, 1, "湘潭市"),
                new Area(7, 2, "成都市"),
                new Area(8, 2, "绵阳市"),
                new Area(9, 2, "自贡市"),
                new Area(10, 3, "鄂州市"),
                new Area(11, 3, "荆门市"),
                new Area(12, 3, "孝感市"),

                new Area(13, 4, "岳麓区"),
                new Area(14, 4, "望城区"),

                new Area(15, 5, "荷塘"),
                new Area(16, 5, "石峰"),

                new Area(17, 6, "韶山"),
                new Area(18, 6, "雨湖"),

                new Area(19, 7, "青羊"),
                new Area(20, 7, "武侯"),


                new Area(21, 8, "涪城"),
                new Area(22, 8, "游仙"),

                new Area(23, 9, "大安"),
                new Area(24, 9, "沿滩"),

                new Area(25, 10, "鄂城"),
                new Area(26, 10, "华容"),

                new Area(27, 11, "辖东宝"),
                new Area(28, 11, "掇刀"),


                new Area(29, 12, "孝南区"),
                new Area(30, 12, "孝昌县")
        );
    }

    public static List<AreaVo> selectAll() {
        //1.查询地区
        List<Area> list = data;
        List<AreaVo> allList = list.stream().map(item -> {
            AreaVo areaVo = new AreaVo();
            areaVo.setId(item.getId());
            areaVo.setPid(item.getPid());
            areaVo.setName(item.getName());
            return areaVo;
        }).collect(Collectors.toList());
        //2.获取省
        List<AreaVo> provinceList = allList.stream().filter(item -> item.getPid() == 0).collect(Collectors.toList());
        List<AreaVo> areaVos = buildTreeByStack(allList, provinceList);
        return areaVos;
    }


    public static List<AreaVo> buildTreeByStack(List<AreaVo> treeNodes, List<AreaVo> parentNodes) {
        Stack<AreaVo> stack = new Stack<>();
        //根入栈
        parentNodes.forEach(e -> stack.push(e));

        List<AreaVo> root = new ArrayList<>();
        while (!stack.isEmpty()) {
            AreaVo currentRoot = stack.pop();
            List<AreaVo> children = new ArrayList<>();

            Iterator<AreaVo> iterator = treeNodes.iterator();
            while (iterator.hasNext()) {
                AreaVo next = iterator.next();
                if (currentRoot.getId().toString().equals(next.getPid().toString())) {
                    children.add(next);
                    iterator.remove();
                }
            }

            currentRoot.setChildren(children);
            if (!children.isEmpty()) {
                //子节点不为空入栈
                children.forEach(e -> stack.push(e));
            }
            if (currentRoot.getPid() == 0) {
                root.add(currentRoot);
            }
        }
        return root;
    }

    /**
     * 树化省市区
     */
    public static void main(String[] args) {
        String jsonString = JSON.toJSONString(selectAll());
        System.out.println(jsonString);
    }
}
