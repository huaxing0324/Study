package com.example.demo.entity;

import com.alibaba.excel.annotation.ExcelProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class TaxEptTimeExportModel {



    /**
     * 污染物类别名称（第一类名称） <first_type_name(java.lang.String)>
     */
    @ExcelProperty(index = 0)
    @ApiModelProperty(value = "污染物类别名称（第一类名称）")
    private String firstTypeName;

    /**
     * 水污染物种类名称（第二类名称） <second_type_name(java.lang.String)>
     */
    @ExcelProperty(index = 1)
    @ApiModelProperty(value = "水污染物种类名称（第二类名称）")
    private String secondTypeName;

    /**
     * 污染物名称 <pollutants_name(java.lang.String)>
     */
    @ExcelProperty(index = 2)
    @ApiModelProperty(value = "污染物名称")
    private String pollutantsName;

    /**
     * 征收子目名称 <tax_subheading_name(java.lang.String)>
     */
    @ExcelProperty(index = 3)
    @ApiModelProperty(value = "征收子目名称")
    private String taxSubheadingName;

    @ExcelProperty(index = 4)
    @ApiModelProperty(value = "污染当量数")
    private BigDecimal taxBasis;

    @ExcelProperty(index = 5)
    @ApiModelProperty(value = "减免性质代码和项目名称")
    private String reduceName;

    /**
     * 单位税额 <unit_tax(java.math.BigDecimal)>
     */
    @ExcelProperty(index = 6)
    @ApiModelProperty(value = "单位税额")
    private BigDecimal unitTax;

    /**
     * 应纳税额 <tax_amount(java.math.BigDecimal)>
     */
    @ExcelProperty(index = 7)
    @ApiModelProperty(value = "应纳税额")
    private BigDecimal taxAmount;
    /**
     * 减免税额 <tax_reduce(java.math.BigDecimal)>
     */
    @ExcelProperty(index = 8)
    @ApiModelProperty(value = "减免税额")
    private BigDecimal taxReduce;
    /**
     * 已缴税额 <tax_paid(java.math.BigDecimal)>
     */
    @ExcelProperty(index = 9)
    @ApiModelProperty(value = "已缴税额")
    private BigDecimal taxPaid;
    /**
     * 应补（退）税额 <tax_refund(java.math.BigDecimal)>
     */
    @ExcelProperty(index = 10)
    @ApiModelProperty(value = "应补（退）税额")
    private BigDecimal taxRefund;

}
