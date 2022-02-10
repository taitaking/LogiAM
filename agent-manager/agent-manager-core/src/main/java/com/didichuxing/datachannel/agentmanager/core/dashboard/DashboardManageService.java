package com.didichuxing.datachannel.agentmanager.core.dashboard;

import com.didichuxing.datachannel.agentmanager.common.bean.vo.dashboard.DashBoardVO;

/**
 * dashboard管理服务
 */
public interface DashboardManageService {

    /**
     * @return 返回当前时间构建的DashBoardVO对象
     */
    DashBoardVO build();

}
