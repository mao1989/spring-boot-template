package com.w15104.dataengine.study.controller;

import com.github.pagehelper.PageInfo;
import com.w15104.dataengine.study.pojo.Product;
import com.w15104.dataengine.study.service.IProductService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.prefs.AbstractPreferences;

/*
 *
 * @Description 产品控制器
 *
 * @author w15104
 * @data: 2019-3-5
 *
 * @modified by:
 * @modified date:
 * @modified no:
 */
@RestController
@RequestMapping("product")
public class ProductController {

    //获取产品服务
    @Resource
    private IProductService productService;

    /**
     * Description: 分页查询产品信息 http://localhost:8181/wfh/product/getPage
     * @param pageNo: 查询第几页
     * @param pageSize 每页数量
     * @return PageInfo 分页信息
     */
    @RequestMapping(value = "/getPage/{pageNo}/{pageSize}}")
    @ResponseBody
    public PageInfo getPage(@PathVariable Integer pageNo, @PathVariable Integer pageSize){
        List<Product> products = productService.getListWithPage(pageNo,pageSize);
        PageInfo<Product> pageInfo = new PageInfo<>(products);
        return pageInfo;
    }

    /**
     * Description: 获取所有产品信息
     * @return List<Product>
     */
    @RequestMapping(value = "/getAll")
    @ResponseBody
    public List<Product> getAll(){
        return productService.getListWithPage(null,null);
    }

    /**
     * Description: 添加商品
     * @param product 产品信息
     * @return String
     */
    @RequestMapping(value = "/add")
    @ResponseBody
    public String addProduct(Product product){
        int result = productService.add(product);
        return result > 0 ? "添加商品成功" : "添加失败";
    }

    /**
     * Description: 删除商品
     * @param id 产品ID
     * @return String
     */
    @RequestMapping(value = "/delete")
    @ResponseBody
    public String detete(Integer id){
        int result = productService.deleteById(id);
        return result > 0 ? "删除商品成功" : "删除失败";
    }

}