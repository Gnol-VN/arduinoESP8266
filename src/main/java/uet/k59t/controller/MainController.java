package uet.k59t.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uet.k59t.model.TempHumid;
import uet.k59t.repository.TempHumidRepository;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;

/**
 * Created by Longlaptop on 11/2/2017.
 */
@RestController
public class MainController {
    @Autowired
    TempHumidRepository tempHumidRepository;

    @RequestMapping(value = "/{temperature}/{humidity}", method = RequestMethod.GET)
    public TempHumid uploadTempHumid(@PathVariable("temperature") Long temperature, @PathVariable("humidity") Long humidity){
        String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new java.util.Date());
//        String result = Long.toString(temperature)+" "+String.valueOf(humidity)+" "+timeStamp;
        TempHumid tempHumid = new TempHumid();
        tempHumid.setTemperature(temperature);
        tempHumid.setHumidity(humidity);
        tempHumid.setTimestamp(timeStamp);
        tempHumidRepository.save(tempHumid);
        return tempHumid;
    }
}
