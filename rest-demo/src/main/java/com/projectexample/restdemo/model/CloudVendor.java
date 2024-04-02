package com.projectexample.restdemo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="Cloud_Vendor_Info")
public class CloudVendor {
    @Id
    String VendorId;

    //validation for input user
    @NotEmpty
    String  VendorName;
    @NotEmpty
    String VendorAddress;
    @NotEmpty
    @Size(min=10,max=10 ,message =  "Oops! The phone number format is not correct")
    @Pattern(regexp="(^$|[0-9]{10})")
    String VendorPhoneNo;

    public String getVendorId() {
        return VendorId;
    }

    public void setVendorId(String vendorId) {
        VendorId = vendorId;
    }

    public String getVendorName() {
        return VendorName;
    }

    public void setVendorName(String vendorName) {
        VendorName = vendorName;
    }

    public String getVendorAddress() {
        return VendorAddress;
    }

    public void setVendorAddress(String vendorAddress) {
        VendorAddress = vendorAddress;
    }

    public String getVendorPhoneNo() {
        return VendorPhoneNo;
    }

    public void setVendorPhoneNo(String vendorPhoneNo) {
        VendorPhoneNo = vendorPhoneNo;
    }


    public CloudVendor() {
    }


    public CloudVendor(String vendorId, String vendorName, String vendorAddress, String vendorPhoneNo) {
        VendorId = vendorId;
        VendorName = vendorName;
        VendorAddress = vendorAddress;
        VendorPhoneNo = vendorPhoneNo;
    }



}
