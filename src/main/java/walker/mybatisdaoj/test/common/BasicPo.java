package walker.mybatisdaoj.test.common;


import com.alibaba.fastjson.JSONObject;

import java.io.Serializable;


/**
 * PO 基类
 * <p/>
 * @Author HuQingmiao
 */
public abstract class BasicPo implements Serializable {

    @Override
    public String toString(){
        return JSONObject.toJSONString(this);
    }


}

