package hj.controller;

import java.io.File;
import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import hj.dao.MessageDao;
import hj.dao.StoreDao;

@Controller
@RequestMapping("/store")
public class StoreController{
	Logger logger = Logger.getLogger(this.getClass());

	@Autowired
	private StoreDao storeDao = null;

/*���������� �̵� �׽�Ʈ*/
	@RequestMapping("/empty.hon")
	public String empty(Model mod, @RequestParam Map<String,Object> pMap, HttpServletResponse res) {
		List<Map<String,Object>> emptyList = null;
		logger.info("empty�޼ҵ� ȣ��");
		//tLogic.test(pMap);
		/*try {
			mDao.check(pMap);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		return "redirect:main.jsp";
	}
	//���Ե��
	@ResponseBody
	@RequestMapping("/storeAdd.hon")
	public String insert(Model mod, @RequestParam Map<String,Object> pMap, HttpServletResponse res) {
		logger.info("pMap" + pMap);
		int result = 0;
		try {
			result = storeDao.storeAdd(pMap);
		} catch (IOException e) {
			e.printStackTrace();
			logger.info("@@@@@@@@@@@@    Dao ����    @@@@@@@@@@@@@@@");
		}
		return String.valueOf(result);
	}
	@ResponseBody
	@RequestMapping("/storeImg.hon")
	public String imgUpload(MultipartHttpServletRequest multi) {
		logger.info("storeImgȣ�⼺��");
		//������ ����
		String path = "C:\\Users\\516\\git\\F.HON\\sp-Honjaopseoye\\WebContent\\store\\storeImg";
		//���� ���� ��� Ȯ��, ������ ����
		File dir = new File(path);
		if(!dir.exists()) {
			dir.mkdirs();
		}
		//���� �̸� ����
		UUID uuid = UUID.randomUUID();
		Iterator<String> files = multi.getFileNames();
		while(files.hasNext()) {
			String uploadFile = files.next();
			logger.info(uploadFile);
			
			MultipartFile mFile = multi.getFile(uploadFile);
			String fileName = mFile.getOriginalFilename();
			logger.info(fileName);
			String saveName = uuid+"_"+fileName; //�����ߺ� �������� �̸�����
			logger.info("saveName:"+saveName);
			File saveFile = new File(path,saveName);
		
			try {
				mFile.transferTo(saveFile);
			} catch (IOException e) {
				e.printStackTrace();
				}
			return saveName; //@ResponseBody�Ἥ ���ϰ��� ��ΰ� �ƴ϶� string������ �����°� ������
		}//end of while
		
				
		
		return null;
	}

}
