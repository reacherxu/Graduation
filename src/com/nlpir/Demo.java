package com.nlpir;
import com.sun.jna.Native;

public class Demo {
	
    
    public static void main(String[] args) throws Exception {
        //初始化
        CLibrary instance = (CLibrary)Native.loadLibrary(
        		System.getProperty("user.dir")+"\\source\\NLPIR", CLibrary.class);
        int init_flag = instance.NLPIR_Init("", 1, "0");
        String resultString = null;
        if (0 == init_flag) {
            resultString = instance.NLPIR_GetLastErrorMsg();
            System.err.println("初始化失败！\n"+resultString);
            return;
        }
                
//        String sInput = "东方网12月4日消息：2009年10月21日,辽宁省阜新市委收到举报信,举报以付玉红为首吸毒、强奸、聚众淫乱,阜新市委政法委副书记于洋等参与吸毒、强奸、聚众淫乱等。对此,阜新市委高度重视,责成阜新市公安局立即成立调查组,抽调精干力量展开调查。　　调查期间,署名举报人上官宏祥又通过尹东方(女)向阜新市公安局刑警支队提供书面举报,举报于洋等参与吸毒、强奸、聚众淫乱。11月19日,正义网发表上官宏祥接受记者专访,再次实名举报于洋等参与吸毒、强奸、聚众淫乱,引起网民广泛关注。对此辽宁省政法委、省公安厅高度重视。当日,责成有关领导专程赴阜新听取案件调查情况。为加强对案件的督办和指导,省有关部门迅速成立工作组,赴阜新督办、指导案件调查工作,并将情况上报有关部门。　　经前一段调查证明,举报事实不存在,上官宏祥行为触犯《刑法》第243条,涉嫌诬告陷害罪。根据《刑事诉讼法》有关规定,阜新市公安局已于11月27日依法立案侦查。上官宏祥已于2009年12月1日到案,12月2日阜新市海州区人大常委会已依法停止其代表资格,阜新市公安局对其进行刑事拘留,并对同案人尹东方进行监视居住。现侦查工作正在进行中。";

        String sInput = "The life sentence imposed at the time sparked angry street protests.";
        try {
            resultString = instance.NLPIR_ParagraphProcess(sInput, 1);
            System.out.println("分词结果为：\n " + resultString);
            
           /* String utf8File = "./test/18届三中全会.TXT";
    		String utf8FileResult = "./test/18届三中全会_res.TXT";
    		instance.NLPIR_FileProcess(utf8File, utf8FileResult,1);
            instance.NLPIR_AddUserWord("金刚圈");
            instance.NLPIR_AddUserWord("左宽右窄");
            resultString = instance.NLPIR_ParagraphProcess(sInput, 1);
            System.out.println("增加用户词典后分词结果为：\n" + resultString);
            
            instance.NLPIR_DelUsrWord("左宽右窄");
            resultString = instance.NLPIR_ParagraphProcess(sInput, 1);
            System.out.println("删除用户词典后分词结果为：\n" + resultString);
            
            instance.NLPIR_ImportUserDict(System.getProperty("user.dir")+"\\source\\userdic.txt");
            resultString = instance.NLPIR_ParagraphProcess(sInput, 1);
            System.out.println("导入用户词典文件后分词结果为：\n" + resultString);*/
            
            resultString = instance.NLPIR_GetKeyWords(sInput,10,false);
            System.out.println("从段落中提取的关键词：\n" + resultString);
            
            resultString = instance.NLPIR_GetNewWords(sInput, 10, false);
            System.out.println("新词提取结果为：\n" + resultString);
            
        /*    Double d = instance.NLPIR_FileProcess("d:\\1.txt", "d:\\2.txt", 1);
            
            System.out.println("对文件内容进行分词的运行速度为： " );
            if(d.isInfinite())
                System.out.println("无结果");
            else{
                BigDecimal b = new BigDecimal(d);
                System.out.println(b.divide(new BigDecimal(1000), 2, BigDecimal.ROUND_HALF_UP)+"秒");                
            }
            resultString = instance.NLPIR_GetFileKeyWords("D:\\3.txt", 10,false);
            System.out.println("从文件中提取关键词的结果为：\n" + resultString);    */        
            
            instance.NLPIR_Exit();

        } catch (Exception e) {
            System.out.println("错误信息：");
            e.printStackTrace();
        }

    }
}