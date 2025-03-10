package com.techlabs.mybank.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import com.techlabs.mybank.Exceptions.InvalidRequestException;
import com.techlabs.mybank.Model.Customers;
import com.techlabs.mybank.Model.Notifications;
import com.techlabs.mybank.Model.Requests;
import com.techlabs.mybank.Model.StatusOptions;
import com.techlabs.mybank.Service.CustomerService;
import com.techlabs.mybank.Service.NotificationsService;
import com.techlabs.mybank.Service.RequestService;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
@CrossOrigin(origins = "http://localhost:8080")
@RestController
public class NotificationsController {

    @Autowired
    private NotificationsService notificationsService;

    @Autowired
    private  CustomerService customerService;

    @GetMapping("/notifications")
    public List<Notifications> getALlRequests(){
        return notificationsService.getALlNotifications();
    }

    @PostMapping("/send_notifications_to_Customer/{accNo}")
    public Notifications addNotifications(@RequestBody Notifications notifications,@PathVariable String accNo){
        if(!customerService.getCustomerByAccNo(accNo).isPresent()){
            throw new InvalidRequestException("Customers with Acc No " +
                    accNo + " does not exist.");
        }
        Customers customer = customerService.getCustomerByAccNo(accNo).get();
        System.out.println(customer);
        notifications.setCustomers(customer);
        Format formatter = new SimpleDateFormat("dd-MMM-yy hh:mm:ss");
        String str = formatter.format(new Date());
        notifications.setDate(str);
        notifications.setStatus(String.valueOf(StatusOptions.UNSEEN));
        System.out.println(notifications);
        return notificationsService.add(notifications);
    }


    @DeleteMapping("/delete/notifications/{id}")
    public void  delete(@PathVariable int id) {
        if (!notificationsService.getNotificationById(id).isPresent()) {
            throw new InvalidRequestException("Notification with ID " +
                    id + " does not exist.");
        }
        notificationsService.delete(id);
    }

    @GetMapping("/getNotification/{accNo}")
    public List<Notifications> getNotifications(@PathVariable String accNo)
    {
        if(!customerService.getCustomerByAccNo(accNo).isPresent()) {
            throw new InvalidRequestException("Customer with AccNo " +
                    accNo + " does not exist.");
        }
        return notificationsService.getNotificationByAcc(accNo);

    }

    @GetMapping("/getUnseenNotification/{accNo}")
    public List<Notifications> getNotificationsUnseen(@PathVariable String accNo)
    {
        if(!customerService.getCustomerByAccNo(accNo).isPresent()) {
            throw new InvalidRequestException("Customer with AccNo " +
                    accNo + " does not exist.");
        }
        return notificationsService.getNotificationByAccAndUnseen(accNo);

    }

    @GetMapping ("/seen/noti/{id}")
    public void seen( @PathVariable int id) {
        if(notificationsService.getNotificationById(id).isPresent()) {
            notificationsService.seen(id);
        }
        else {
            throw new InvalidRequestException("Notification with ID " +
                    id + " does not exist.");
        }
    }

}
