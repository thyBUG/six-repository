package com.aaa.lee.app.mapper;

import com.aaa.lee.app.domain.History;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface HistoryMapper extends Mapper<History> {
    List<History>  selectMemberId(Long id);
}