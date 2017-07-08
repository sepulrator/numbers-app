package com.numbersapp.number.controller;

import com.numbersapp.number.common.OrderType;
import com.numbersapp.number.dto.domain.NumberDTO;
import com.numbersapp.number.exception.RecordNotFoundException;
import com.numbersapp.number.service.impl.NumberAggregateService;
import com.numbersapp.number.service.impl.NumberCrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by sepulrator on 08.07.2017.
 */
@RestController
@RequestMapping("/numbers")
public class NumberController {

    @Autowired
    private NumberCrudService numberCrudService;

    @Autowired
    private NumberAggregateService numberAggregateService;

    @RequestMapping(value = "",method = RequestMethod.GET)
    public List<NumberDTO> getNumberDTOList(@RequestParam(value="sort", required=false) String inputOrderType) {
        OrderType orderType = OrderType.ASCENDING;
        if (OrderType.DESCENDING.getValue().equals(inputOrderType)) {
            orderType = OrderType.DESCENDING;
        }
        return numberCrudService.getList(orderType);
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public NumberDTO readNumberDTO(@PathVariable("id") long id) {
        return numberCrudService.read(id);
    }

    @RequestMapping(value = "",method = RequestMethod.POST)
    public NumberDTO createNumberDTO(@RequestBody NumberDTO numberDTO) {
        return numberCrudService.create(numberDTO);
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    public void deleteNumberDTO(@PathVariable("id") long id) {
        numberCrudService.delete(id);
    }

    @RequestMapping(value = "/max",method = RequestMethod.GET)
    public NumberDTO getMaxNumber() {
        return numberAggregateService.getMaxEntity();
    }

    @RequestMapping(value = "/min",method = RequestMethod.GET)
    public NumberDTO getMinNumber() {
        return numberAggregateService.getMinEntity();
    }

}
