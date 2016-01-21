package com.bayes;

import java.io.IOException;

import jeasy.analysis.MMAnalyzer;

/**
* 中文分词器
*/
public class ChineseSpliter 
{
	/**
	* 对给定的文本进行中文分词
	* @param text 给定的文本
	* @param splitToken 用于分割的标记,如"|"
	* @return 分词完毕的文本
	*/
	public static String split(String text,String splitToken)
	{
		String result = null;
		MMAnalyzer analyzer = new MMAnalyzer();  	
		try  	
        {
			result = analyzer.segment(text, splitToken);	
		}  	
        catch (IOException e)  	
        { 	
        	e.printStackTrace(); 	
        } 	
        return result;
	}
	
	public static void main(String[] args) {
		String sInput = "东方网12月4日消息：2009年10月21日,辽宁省阜新市委收到举报信,举报以付玉红为首吸毒、强奸、聚众淫乱,阜新市委政法委副书记于洋等参与吸毒、强奸、聚众淫乱等。对此,阜新市委高度重视,责成阜新市公安局立即成立调查组,抽调精干力量展开调查。　　调查期间,署名举报人上官宏祥又通过尹东方(女)向阜新市公安局刑警支队提供书面举报,举报于洋等参与吸毒、强奸、聚众淫乱。11月19日,正义网发表上官宏祥接受记者专访,再次实名举报于洋等参与吸毒、强奸、聚众淫乱,引起网民广泛关注。对此辽宁省政法委、省公安厅高度重视。当日,责成有关领导专程赴阜新听取案件调查情况。为加强对案件的督办和指导,省有关部门迅速成立工作组,赴阜新督办、指导案件调查工作,并将情况上报有关部门。　　经前一段调查证明,举报事实不存在,上官宏祥行为触犯《刑法》第243条,涉嫌诬告陷害罪。根据《刑事诉讼法》有关规定,阜新市公安局已于11月27日依法立案侦查。上官宏祥已于2009年12月1日到案,12月2日阜新市海州区人大常委会已依法停止其代表资格,阜新市公安局对其进行刑事拘留,并对同案人尹东方进行监视居住。现侦查工作正在进行中。";
		System.out.println(split(sInput,"/"));
	}
	
	
}
