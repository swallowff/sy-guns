package cn.bigfish.syna.core.util;

import cn.hutool.core.date.DateUtil;

import java.util.Date;

/**
 * @author shenyu
 * @create 2019/2/10
 */
public class CommonUtil {
    public static String formatDateTime(Date date,String parttern){
        return DateUtil.format(date,parttern);
    }
}
