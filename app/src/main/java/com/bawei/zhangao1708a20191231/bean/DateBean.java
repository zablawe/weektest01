package com.bawei.zhangao1708a20191231.bean;

import java.util.List;

/**
 * author: 张奥
 * data: 2019-09-29
 * function:
 */
public class DateBean
{
    private List <SmsesBean> smses;

    public List <SmsesBean> getSmses() {
        return smses;
    }

    public void setSmses(List <SmsesBean> smses) {
        this.smses = smses;
    }

    public static class SmsesBean {
        /**
         * from : 10006666
         * content : 【中国电信】电信营业厅APP签到活动，到期倒计时送200个流量币，充值薅5元话费~手慢无，快快快戳：http://a.189.cn/v6VEB7 回复TD将不再接收此类信息
         * time : 昨天
         * isread : 1
         */

        private String from;
        private String content;
        private String time;
        private int isread;

        public String getFrom() {
            return from;
        }

        public void setFrom(String from) {
            this.from = from;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getTime() {
            return time;
        }

        public void setTime(String time) {
            this.time = time;
        }

        public int getIsread() {
            return isread;
        }

        public void setIsread(int isread) {
            this.isread = isread;
        }
    }
}
