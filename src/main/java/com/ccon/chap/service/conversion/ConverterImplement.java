package com.ccon.chap.service.conversion;

import com.ccon.chap.dto.view.ValCursView;
import com.ccon.chap.entity.History;
import com.ccon.chap.entity.User;
import com.ccon.chap.entity.ValCurs;
import com.ccon.chap.service.history.HistoryService;
import com.ccon.chap.service.user.UserService;
import com.ccon.chap.service.valcurs.ValCursService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;

@Service
@Transactional
public class ConverterImplement implements ConverterService {
    private final HistoryService historyService;
    private final ValCursService valCursService;
    private final UserService userService;

    @Autowired
    public ConverterImplement(HistoryService historyService, ValCursService valCursService, UserService userService) {
        this.historyService = historyService;
        this.valCursService = valCursService;
        this.userService = userService;
    }

    @Override
    public ValCursView conversion(List<ValCurs> valCursList, ValCursView valCursView, User user) {
        /*
         * You can't use ValCursService because the List<Values> values List contains a list of currencies of a certain date.
         * After that, we are looking for target currencies.
         * Нельзя воспользоваться ValCursService потому что List<ValCurs> valCursList содержит в себе список  валют определенной даты.
         * После чего мы ищем целевые валюты.
         * */
        ValCurs currencyOf = valCursService.findValCursByWriteId(1L);
        ValCurs currencyIn = valCursService.findValCursByWriteId(1L);
        for (ValCurs valCurs : valCursList) {
            if (valCursView.getNameValuteOne().equals(valCurs.getCurrency_name())) {
                currencyOf = valCurs;
            }
            if (valCursView.getNameValuteTwo().equals(valCurs.getCurrency_name())) {
                currencyIn = valCurs;
            }
        }
        /*
         * If the user has chosen rubles as the target currency, then we determine in which field it is present, and assign it to the desired entity.
         * Если пользователь выбрал как целевую валюту рубли, то определяем в каком поле она присутствует, и присваиваем в нужную сущность.
         *
         * If the String valCursView.getNameValuteOne field contains the string "rubles", and currencyOf is empty.
         * Then we transfer the data from the database to currencyOf (It will be rubles).
         * Then we pass the real value to the valueTwo variable via ParserFloat.
         * The ruble cannot participate in saving the history because the time data is not reliable.
         * Если в поле String valCursView.getNameValuteOne присутствует строка "рубли", а currencyOf пуста.
         * То мы передаем данные из БД в currencyOf (Это будут рубли).
         * Потом мы передаем в вещественное значение в переменную valueTwo посредством ParserFloat.
         * В сохранении истории рубль участвовать не может так как данные времени не доставерны.
         * */
        if (valCursView.getNameValuteOne().equals("Рублей") && valCursView.getValueValuteOne().isEmpty()) {
            float valueTwo = Float.parseFloat(valCursView.getValueValuteTwo());
            float answer = valueTwo * Float.parseFloat(currencyIn.getCurrency_value());
            valCursView.setValueValuteOne(String.valueOf(answer));
            History history = new History(valCursService.findValCursByWriteId(currencyOf.getWrite_id()),
                    valCursService.findValCursByWriteId(currencyIn.getWrite_id()),
                    userService.findByUserId(user.getUser_id()),
                    valueTwo, answer,
                    currencyIn.getCurrency_date(),
                    LocalDateTime.now());
            historyService.saveHistory(history);
            return valCursView;
        }

        if (valCursView.getNameValuteTwo().equals("Рублей") && valCursView.getValueValuteTwo().isEmpty()) {
            float valueOne = Float.parseFloat(valCursView.getValueValuteOne());
            float answer = valueOne * Float.parseFloat(currencyOf.getCurrency_value());
            valCursView.setValueValuteTwo(String.valueOf(answer));
            History history = new History(valCursService.findValCursByWriteId(currencyOf.getWrite_id()),
                    valCursService.findValCursByWriteId(currencyIn.getWrite_id()),
                    userService.findByUserId(user.getUser_id()),
                    valueOne, answer,
                    currencyOf.getCurrency_date(),
                    LocalDateTime.now());
            historyService.saveHistory(history);
            return valCursView;
        }

        if (valCursView.getValueValuteTwo().isEmpty()) {
            float valueOne = Float.parseFloat(valCursView.getValueValuteOne());
            float answer = (valueOne * Float.parseFloat(currencyOf.getCurrency_value())) / Float.parseFloat(currencyIn.getCurrency_value());
            valCursView.setValueValuteTwo(String.valueOf(answer));
            History history = new History(valCursService.findValCursByWriteId(currencyOf.getWrite_id()),
                    valCursService.findValCursByWriteId(currencyIn.getWrite_id()),
                    userService.findByUserId(user.getUser_id()),
                    valueOne, answer,
                    currencyIn.getCurrency_date(),
                    LocalDateTime.now());
            historyService.saveHistory(history);
            return valCursView;
        }

        if (valCursView.getValueValuteOne().isEmpty()) {
            float valueTwo = Float.parseFloat(valCursView.getValueValuteTwo());
            float answer = (valueTwo * Float.parseFloat(currencyIn.getCurrency_value())) / Float.parseFloat(currencyOf.getCurrency_value());
            valCursView.setValueValuteOne(String.valueOf(answer));
            History history = new History(valCursService.findValCursByWriteId(currencyOf.getWrite_id()),
                    valCursService.findValCursByWriteId(currencyIn.getWrite_id()),
                    userService.findByUserId(user.getUser_id()),
                    valueTwo, answer,
                    currencyOf.getCurrency_date(),
                    LocalDateTime.now());
            historyService.saveHistory(history);
            return valCursView;
        }
        return valCursView;
    }
}
