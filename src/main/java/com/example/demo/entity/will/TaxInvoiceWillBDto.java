package com.example.demo.entity.will;

import java.math.BigDecimal;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

/**
 * @Description：TODO
 * @Author：guoqiangfeng
 * @Date：2022/11/4 上午11:30
 */
@Getter
@Setter
public class TaxInvoiceWillBDto {

  /* 发票种类,uri:yonbip-fi-taxotypd.yonbip-fi-taxotypd.tax_invoice_will_b.invoiceTypeId */
  private String invoiceTypeId;
  @NotBlank(message = "发票种类编码不能为空")
  @Length(max = 20, message = "发票种类编码的最大长度不能超过20")
  private String invoiceTypeCode;
  /* 开票状态,uri:yonbip-fi-taxotypd.yonbip-fi-taxotypd.tax_invoice_will_b.invoiceState */
//  private String invoiceState;
  /* 单据类型,uri:yonbip-fi-taxotypd.yonbip-fi-taxotypd.tax_invoice_will_b.billType */
  @Length(max = 100, message = "单据类型的最大长度不能超过100")
  private String billType;

  /**
   * 制单日期
   */

//  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
//  private Date prepareDate;
//  public Date getPrepareDate() {
//    if(StringUtils.isNotEmpty(this.getPrepareDateStr())){
//      return DateTimeUtils.toDate(this.prepareDateStr, "yyyy-MM-dd HH:mm:ss");
//    }
//    return null;
//  }
//  @DateFormat(format = "yyyy-MM-dd HH:mm:ss", message = "制单日期格式错误")
//  private String prepareDateStr;
  /* 开票单号,uri:yonbip-fi-taxotypd.yonbip-fi-taxotypd.tax_invoice_will_b.invoiceNo */
  @Length(max = 20, message = "开票单号的最大长度不能超过20")
  private String invoiceNo;
  /* 订单号,uri:yonbip-fi-taxotypd.yonbip-fi-taxotypd.tax_invoice_will_b.orderNo */
  /* 来源单据号,uri:yonbip-fi-taxotypd.yonbip-fi-taxotypd.tax_invoice_will_b.outSourceCode */
  @Length(max = 100, message = "来源单据号的最大长度不能超过100")
  private String outSourceCode;
  /* 来源单据ID,uri:yonbip-fi-taxotypd.yonbip-fi-taxotypd.tax_invoice_will_b.outSourceId */
  @Length(max = 100, message = "来源单据ID的最大长度不能超过100")
  private String outSourceId;
  @Length(max = 100, message = "订单号的最大长度不能超过100")
  private String orderNo;
  /* 合同号,uri:yonbip-fi-taxotypd.yonbip-fi-taxotypd.tax_invoice_will_b.contractNo */
  @Length(max = 100, message = "合同号的最大长度不能超过100")
  private String contractNo;
  /* 发货单号,uri:yonbip-fi-taxotypd.yonbip-fi-taxotypd.tax_invoice_will_b.shipmentNo */
  @Length(max = 100, message = "发货单号的最大长度不能超过100")
  private String shipmentNo;
  /* 采购单号,uri:yonbip-fi-taxotypd.yonbip-fi-taxotypd.tax_invoice_will_b.purchaseNo */
  @Length(max = 100, message = "采购单号的最大长度不能超过100")
  private String purchaseNo;
  /* 报关单号,uri:yonbip-fi-taxotypd.yonbip-fi-taxotypd.tax_invoice_will_b.customsDeclarationNo */
  @Length(max = 100, message = "报关单号的最大长度不能超过100")
  private String customsDeclarationNo;
  /* 客户档案,uri:yonbip-fi-taxotypd.yonbip-fi-taxotypd.tax_invoice_will_b.bdcustomerId */
  private String bdcustomerId;
  /* 购方编码,uri:yonbip-fi-taxotypd.yonbip-fi-taxotypd.tax_invoice_will_b.buyCode */
  @Length(max = 100, message = "购方编码的最大长度不能超过100")
  private String buyCode;
  /* 购方名称,uri:yonbip-fi-taxotypd.yonbip-fi-taxotypd.tax_invoice_will_b.buyName */
  @Length(max = 100, message = "购方名称的最大长度不能超过100")
  private String buyName;
  /* 购方纳税人识别号,uri:yonbip-fi-taxotypd.yonbip-fi-taxotypd.tax_invoice_will_b.buyNsrsbh */
  @Length(max = 100, message = "购方纳税人识别号的最大长度不能超过100")
  private String buyNsrsbh;
  /* 购方地址电话,uri:yonbip-fi-taxotypd.yonbip-fi-taxotypd.tax_invoice_will_b.buyAddress */
  @Length(max = 100, message = "购方地址电话的最大长度不能超过100")
  private String buyAddress;
  /* 购方开户行及账号,uri:yonbip-fi-taxotypd.yonbip-fi-taxotypd.tax_invoice_will_b.buyBank */
  @Length(max = 100, message = "购方开户行及账号的最大长度不能超过100")
  private String buyBank;
  /* 购方联系人,uri:yonbip-fi-taxotypd.yonbip-fi-taxotypd.tax_invoice_will_b.buyContact */
//  @Length(max = 100, message = "购方联系人的最大长度不能超过100")
//  private String buyContact;
  /* 购方邮箱地址,uri:yonbip-fi-taxotypd.yonbip-fi-taxotypd.tax_invoice_will_b.buyEmail */
  @Length(max = 100, message = "购方邮箱地址的最大长度不能超过100")
  private String buyEmail;
  /* 收件人手机,uri:yonbip-fi-taxotypd.yonbip-fi-taxotypd.tax_invoice_will_b.buyTel */
  @Length(max = 100, message = "收件人手机的最大长度不能超过100")
  private String buyTel;
  /* 发票备注,uri:yonbip-fi-taxotypd.yonbip-fi-taxotypd.tax_invoice_will_b.remark */
  @Length(max = 200, message = "明细发票备注的最大长度不能超过200")
  private String remark;
  /* 发票行性质,uri:yonbip-fi-taxotypd.yonbip-fi-taxotypd.tax_invoice_will_b.invoiceNature */
//  @Length(max = 100, message = "购方编码的最大长度不能超过100")
  private String invoiceNature;
  /* 项目,uri:yonbip-fi-taxotypd.yonbip-fi-taxotypd.tax_invoice_will_b.productId */
  private String productId;
  /* 项目名称,uri:yonbip-fi-taxotypd.yonbip-fi-taxotypd.tax_invoice_will_b.productName */
  @Length(max = 100, message = "项目名称的最大长度不能超过90")
  private String productName;
  /* 项目编码,uri:yonbip-fi-taxotypd.yonbip-fi-taxotypd.tax_invoice_will_b.productCode */
  @Length(max = 90, message = "项目编码的最大长度不能超过90")
  private String productCode;

  /* 税收分类编码,uri:yonbip-fi-taxotypd.yonbip-fi-taxotypd.tax_invoice_will_b.taxClassCode */
  @Length(max = 19, message = "税收分类编码的最大长度不能超过19")
  private String taxClassCode;
  @Length(max = 90, message = "商品自行编码的最大长度不能超过90")
  private String productSelfCode;
  /* 规格型号,uri:yonbip-fi-taxotypd.yonbip-fi-taxotypd.tax_invoice_will_b.spec */
  @Length(max = 100, message = "规格型号的最大长度不能超过100")
  private String spec;
  /* 税率,uri:yonbip-fi-taxotypd.yonbip-fi-taxotypd.tax_invoice_will_b.taxRate */
  @Digits(integer = 15, fraction = 10, message = "税率格式不正确(支持15位整数，10位小数")
  private BigDecimal taxRate;
  /* 单位,uri:yonbip-fi-taxotypd.yonbip-fi-taxotypd.tax_invoice_will_b.unit */
  @Length(max = 20, message = "单位的最大长度不能超过20")
  private String unit;
  /* 单价,uri:yonbip-fi-taxotypd.yonbip-fi-taxotypd.tax_invoice_will_b.price */
  @Digits(integer = 15, fraction = 10, message = "明细单价字段格式不正确(支持15位整数，10位小数")
  private BigDecimal price;
  /* 数量,uri:yonbip-fi-taxotypd.yonbip-fi-taxotypd.tax_invoice_will_b.count */
  @Digits(integer = 15, fraction = 10, message = "明细数量字段格式不正确(支持15位整数，10位小数")
  private BigDecimal count;
  /* 价税合计,uri:yonbip-fi-taxotypd.yonbip-fi-taxotypd.tax_invoice_will_b.jshj */
  @Digits(integer = 15, fraction = 10, message = "明细价税合计格式不正确(支持15位整数，10位小数")
  private BigDecimal jshj;
  @Digits(integer = 15, fraction = 10, message = "明细金额格式不正确(支持15位整数，10位小数")
  private BigDecimal je;
  /* 税额,uri:yonbip-fi-taxotypd.yonbip-fi-taxotypd.tax_invoice_will.se */
  @Digits(integer = 15, fraction = 10, message = "明细税额格式不正确(支持15位整数，10位小数")
  private BigDecimal se;
  /* 行号,uri:yonbip-fi-taxotypd.yonbip-fi-taxotypd.tax_invoice_will_b.lineNo */
  @Length(max = 60, message = "行号的最大长度不能超过60")
  private String lineNo;
  /* 单据行ID,uri:yonbip-fi-taxotypd.yonbip-fi-taxotypd.tax_invoice_will_b.docLineId */
  @Length(max = 60, message = "单据行ID的最大长度不能超过100")
  private String docLineId;
  /* 折扣行号,uri:yonbip-fi-taxotypd.yonbip-fi-taxotypd.tax_invoice_will_b.discountLineNo */
  @Length(max = 60, message = "折扣行号的最大长度不能超过60")
  private String discountLineNo;
  /* 销售优惠标识,uri:yonbip-fi-taxotypd.yonbip-fi-taxotypd.tax_invoice_will_b.saleConcessions */
//  @Length(max = 100, message = "购方编码的最大长度不能超过100")
  //枚举值包括：不使用、使用
  private String saleConcessions;
  /* 零税率标识,uri:yonbip-fi-taxotypd.yonbip-fi-taxotypd.tax_invoice_will_b.zeroRate */
//  @Length(max = 100, message = "购方编码的最大长度不能超过100")
  //枚举 非零利率、出口退税、免税、不征收、普通零税率
  private String zeroRate;
  /* 优惠政策说明,uri:yonbip-fi-taxotypd.yonbip-fi-taxotypd.tax_invoice_will_b.discountDesc */
  @Length(max = 50, message = "优惠政策说明的最大长度不能超过50")
  private String discountDesc;
  /* 扣除额,uri:yonbip-fi-taxotypd.yonbip-fi-taxotypd.tax_invoice_will_b.deductions */
  @Digits(integer = 15, fraction = 10, message = "扣除额格式不正确(支持15位整数，10位小数")
  private BigDecimal deductions;

  /* 发票代码,uri:yonbip-fi-taxotypd.yonbip-fi-taxotypd.tax_invoice_will_b.fpdm */
  @Length(max = 12, message = "原蓝票发票代码的最大长度不能超过100")
  private String fpdm;
  /* 发票号码,uri:yonbip-fi-taxotypd.yonbip-fi-taxotypd.tax_invoice_will_b.fphm */
  @Length(max = 8, message = "原发票号码的最大长度不能超过100")
  private String fphm;
  /* 开票日期,uri:yonbip-fi-taxotypd.yonbip-fi-taxotypd.tax_invoice_will_b.kprq */
//  private String kprq;
  /* 来源申请单号,uri:yonbip-fi-taxotypd.yonbip-fi-taxotypd.tax_invoice_will_b.sourceApplyNo */
//  private String sourceApplyNo;
  /* 红字信息表编号,uri:yonbip-fi-taxotypd.yonbip-fi-taxotypd.tax_invoice_will_b.resBillNo */
  @Length(max = 20, message = "红字信息表编号的最大长度不能超过20")
  private String resBillNo;
  /* 开票申请单,uri:yonbip-fi-taxotypd.yonbip-fi-taxotypd.tax_invoice_will_b.taxInvoiceWillId */
  private String taxInvoiceWillId;

  /* 原始商品名称,uri:yonbip-fi-taxotypd.yonbip-fi-taxotypd.tax_invoice_will_b.oriProductName */
  @Length(max = 90, message = "客户商品名称的最大长度不能超过90")
  private String oriProductName;
  /* 原始商品规格,uri:yonbip-fi-taxotypd.yonbip-fi-taxotypd.tax_invoice_will_b.oriSpec */
  @Length(max = 100, message = "客户规格型号的最大长度不能超过100")
  private String oriSpec;


}
