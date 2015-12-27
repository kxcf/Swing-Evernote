/*
 * Copyright 1999-2015 Alibaba.com All right reserved. This software is the
 * confidential and proprietary information of Alibaba.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Alibaba.com.
 */
package Swing;

import Swing.View.EnterView;
import Swing.View.MainView;

/**
 * 启动程序
 *
 * @version 1.0
 * @since 15/12/28
 */
public class Boot {
    public static void main(String[] args) {
        EnterView enterView = new EnterView();
        enterView.setVisible(true);
        if (enterView.getId() != 0) {
            MainView mainView = new MainView(enterView.getId());
            mainView.setVisible(true);
        }
    }
}
