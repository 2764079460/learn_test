package com.vueblog.mapper;

import com.vueblog.entity.GoodsBean;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/*
 * 文 件 名:  GoodsMapper.java
 * 描       述:  唯一编号
 * 作者:  xiangmiao
 * 时间:  2020-07-11 11:24:07 星期六
 */
@Mapper
public interface GoodsMapper {
	
    /**
     * 
     * @Title: add
     * @author xiangmiao
     * @Description: (新增对象)
     * @return void 返回类型
     * @throws
     */
    public void add(GoodsBean bean);

    /**
     * 
     * @Title: update
     * @author xiangmiao
     * @Description: (修改对象)
     * @return
     * @return int 返回类型
     * @throws
     */
    public int update(GoodsBean bean);

    /**
     * 
     * @Title: updateBySelective
     * @author xiangmiao
     * @Description: (根据内容修改对象)
     * @return
     * @return int 返回类型
     * @throws
     */
    public int updateBySelective(GoodsBean bean);

    /**
     * 
     * @Title: delete
     * @author xiangmiao
     * @Description: (删除对象)
     * @param id
     * @return
     * @return int 返回类型
     * @throws
     */
    public int delete(Long id);

    /**
     * 减库存
     * @param id
     */
    void substractStock(Long id, Integer stock);

    /**
     * 
     * @Title: queryByCount
     * @author xiangmiao
     * @Description: (获取数量)
     * @return
     * @return int 返回类型
     * @throws
     */
    public int queryByCount(GoodsBean bean);

    /**
     * 
     * @Title: queryByPage
     * @author xiangmiao
     * @Description: (分页获取对象)
     * @return
     * @return List<GoodsBean> 返回类型
     * @throws
     */
    public List<GoodsBean> queryByPage(GoodsBean bean);

    /**
     * 
     * @Title: queryByList
     * @author xiangmiao
     * @Description: (获取集合)
     * @return
     * @return List<GoodsBean> 返回类型
     * @throws
     */
    public List<GoodsBean> queryByList(GoodsBean bean);

    /**
     * 
     * @Title: queryById
     * @author xiangmiao
     * @Description: (获取一个对象)
     * @return
     * @return GoodsBean 返回类型
     * @throws
     */
    public GoodsBean queryById(Long id);

    /**
     * 
     * @Title: batchAdd
     * @author xiangmiao
     * @Description: (批量添加)
     * @param list
     * @return void 返回类型
     * @throws
     */
    public void batchAdd(List<GoodsBean> list);

    /**
     * 
     * @Title: batchDelete
     * @author 圣彬彬
     * @Description: (批量删除)
     * @return void 返回类型
     * @throws
     */
    public void batchDelete(List<Long> list);

    /**
     * 
     * @Title: deleteByCondtion
     * @author xiangmiao
     * @Description: (根据条件删除)
     * @return void 返回类型
     * @throws
     */
    public void deleteByCondtion(GoodsBean bean);
	
}
