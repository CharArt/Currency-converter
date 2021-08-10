package com.ccon.chap.service.conversion;

import com.ccon.chap.dto.view.ValCursView;
import com.ccon.chap.entity.User;
import com.ccon.chap.entity.ValCurs;

import java.util.List;

public interface ConverterService {

     ValCursView conversion (List<ValCurs> valCursList, ValCursView valCursView, User user);
}
