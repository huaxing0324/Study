package com.example.demo.entity.will;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.validation.Valid;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

/**
 * @Description：TODO
 * @Author：guoqiangfeng
 * @Date：2022/11/4 上午11:30
 */
@Setter
@Getter
public class TaxInvoiceWillDto {

  /**
   * 申请单号
   */
  @Length(max = 100, message = "申请单号的最大长度不能超过100")
  @NotBlank(message = "申请单号不能为空")
  private String applyNo;
  /**
   * 申请单类型
   */
  @NotBlank(message = "申请单的类型不能为空")
  private String applyType;

//  @NotBlank(message = "开票点编码不能为空")
  @Length(max = 50, message = "开票点编码最大长度不能超过50")
  private String billStationCode;

  /**
   * 开票点id
   */
  private String billStationId;


  /**
   * 申请人
   */
  @Length(max = 100, message = "申请人的最大长度不能超过100")
  private String applyUser;
  @Digits(integer = 15, fraction = 10, message = "总价税合计金额格式不正确(支持15位整数，10位小数")
  @NotNull(message = "总价税合计金额不能为空")
  private BigDecimal jshj;
  @Digits(integer = 15, fraction = 10, message = "总金额格式不正确(支持15位整数，10位小数")
  @NotNull(message = "总金额不能为空")
  private BigDecimal je;
  @Digits(integer = 15, fraction = 10, message = "总税额格式不正确(支持15位整数，10位小数")
  @NotNull(message = "总税额不能为空")
  private BigDecimal se;
  @Length(max = 100, message = "备注最大长度不能超过100")
  private String remark;
  /* 外部来源类型,uri:yonbip-fi-taxotypd.yonbip-fi-taxotypd.tax_invoice_will.sourceType */
  private String sourceType = "3";
  /* 外部来源系统,uri:yonbip-fi-taxotypd.yonbip-fi-taxotypd.tax_invoice_will.sourceSys */
  @Length(max = 100, message = "来源系统最大长度不能超过100")
  private String sourceSys;
  /* 外部来源id,uri:yonbip-fi-taxotypd.yonbip-fi-taxotypd.tax_invoice_will.outSourceId */
  private String outSourceId;
  /* 外部来源编码,uri:yonbip-fi-taxotypd.yonbip-fi-taxotypd.tax_invoice_will.outSourceCode */
  private String outSourceCode;

  /**
   * 销售方纳税人识别号
   */
  @Length(max = 20, message = "销售方纳税人识别号最大长度不能超过20")
  private String saleNsrsbh;

  /* 销售方名称,uri:yonbip-fi-taxotypd.yonbip-fi-taxotypd.tax_invoice_will.saleName */
  @Length(max = 100, message = "销售方名称最大长度不能超过100")
  private String saleName;
  /* 销售方地址电话,uri:yonbip-fi-taxotypd.yonbip-fi-taxotypd.tax_invoice_will.saleAddress */
  @Length(max = 100, message = "销售方地址电话最大长度不能超过100")
  private String saleAddress;
  /* 销售方开户行,uri:yonbip-fi-taxotypd.yonbip-fi-taxotypd.tax_invoice_will.saleBank */
  @Length(max = 100, message = "销售方开户行最大长度不能超过100")
  private String saleBank;
  /* 开票人,uri:yonbip-fi-taxotypd.yonbip-fi-taxotypd.tax_invoice_will.invoiceUser */
  @Length(max = 8, message = "开票人最大长度不能超过8")
//  @NotBlank(message = "开票人不能为空")
  private String invoiceUser;
  /* 收款人,uri:yonbip-fi-taxotypd.yonbip-fi-taxotypd.tax_invoice_will.payeeUser */
  @Length(max = 8, message = "收款人最大长度不能超过8")
  private String payeeUser;
  /* 复核,uri:yonbip-fi-taxotypd.yonbip-fi-taxotypd.tax_invoice_will.reviewUser */
  @Length(max = 8, message = "复核最大长度不能超过8")
  private String reviewUser;

  private String bustype;
  @Length(max = 100, message = "交易类型编码最大长度不能超过100")
  private String bustypeCode;

  /**
   * 详情数据
   */
  @Valid
  private List<TaxInvoiceWillBDto> items;

}
