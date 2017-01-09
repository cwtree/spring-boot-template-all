package com.cmcc.ms.service;

import com.cmcc.ms.dataobject.AdminUser;
import com.cmcc.ms.vo.MsVO;

public interface MsService {

	public MsVO findMs();

	public void addAdminUser(AdminUser au);

	public AdminUser findAdminUserById(Long id);
	
	public void sendMail(String receiver,String subject,String content);

}
