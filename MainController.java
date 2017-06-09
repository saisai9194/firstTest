package busanitstudent.com.Controll;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import busanitstudent.com.Admin.Commend.MemberList_Command;
import busanitstudent.com.Login.Commend.EmailCheck_Command;
import busanitstudent.com.Login.Commend.Join_Command;
import busanitstudent.com.Market.Commend.MInsertCart_Commend;
import busanitstudent.com.Market.Commend.MCartDelete_Commend;
import busanitstudent.com.Market.Commend.MCart_Commend;
import busanitstudent.com.Market.Commend.MDelete_Commend;
import busanitstudent.com.Market.Commend.MEvaluationDelete_Commend;
import busanitstudent.com.Market.Commend.MEvaluation_Commend;
import busanitstudent.com.Market.Commend.MModified_Commend;
import busanitstudent.com.Market.Commend.MNextPage_Commend;
import busanitstudent.com.Market.Commend.MSearch_Commend;
import busanitstudent.com.Market.Commend.MView_Commend;
import busanitstudent.com.Market.Commend.MWrite_Commend;
import busanitstudent.com.ParcelOut.Commend.*;
import busanitstudent.com.Market.Commend.MMenuDetails_Commend;
import busanitstudent.com.Market.Commend.MModifiedSuccess_Commend;


@WebServlet("*.do")
public class MainController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public MainController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		actionDo(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		actionDo(request, response);
	}
	
	private void actionDo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		request.setCharacterEncoding("UTF-8");
		
		String viewPage = null;
		Command command = null;
		
		String uri = request.getRequestURI();
		String conPath = request.getContextPath();
		String com = uri.substring(conPath.length());
		
		if(com.equals("/Login/join.do")) {
			command = new Join_Command();
			command.execute(request, response);
			viewPage = "login.jsp";
		}else if (com.equals("/Login/emailCheck.do")){
			command = new EmailCheck_Command();
			command.execute(request, response);
			viewPage = "email_Check.jsp";
		}
		
		if(com.equals("/Admin/admin_member.do")) {
			command = new MemberList_Command();
			command.execute(request, response);
			viewPage = "admin_member.jsp";
		}else if(com.equals("/Admin/member_delete.do")){
			
			viewPage = "admin_member.jsp";
		}else if(com.equals("/Admin/member_login.do")){
			
			viewPage = "admin_member.jsp";
		}else if(com.equals("/Admin/member_password.do")){
			
			viewPage = "admin_member.jsp";
		}
		
		
		//분양
		
		if(com.equals("/ParcelOut/shareWrite.do")){
			command = new Parcel_ShareWrite_Command();
			command.execute(request, response);
			viewPage = "shareSelect.do";
		}else if(com.equals("/ParcelOut/shareSelect.do")){
			command = new Parcel_NextPage_Command();
			command.execute(request, response);
			viewPage = "shareSelect.jsp";
		}else if(com.equals("/ParcelOut/shareSearchList.do")){
			command = new Parcel_share_Search_Command();
			command.execute(request, response);
			viewPage = "shareSelect.jsp";
		}else if(com.equals("/ParcelOut/shareSelect_nextPage.do")){
			command = new Parcel_NextPage_Command();
			command.execute(request, response);
			viewPage = "shareSelect.do";
		}else if(com.equals("/ParcelOut/sharePosts.do")){
			command = new Parcel_SharePosts_Command();
			command.execute(request, response);
			viewPage = "sharePosts.jsp";
		}else if(com.equals("/ParcelOut/shareModified.do")){
			command = new Parcel_ShareModifiedView_Command();
			command.execute(request, response);
			viewPage = "shareModified.jsp";
		}else if(com.equals("/ParcelOut/shareModified_save.do")){
			command = new Parcel_shareModified_save_Command();
			command.execute(request, response);
			viewPage = "shareSelect.do";
		}else if(com.equals("/ParcelOut/shareDelete.do")){
			command = new Parcel_Delete_Command();
			command.execute(request, response);
			viewPage = "shareSelect.do";
		}else if(com.equals("/ParcelOut/ParcelComment.do")){
			command = new Parcel_Comment_Command();
			command.execute(request, response);
			viewPage = "sharePosts.do";
		}else if(com.equals("/ParcelOut/ParcelCommentDelete.do")){
			command = new Parcel_CommentDelete_Command();
			command.execute(request, response);
			viewPage = "sharePosts.do";
			
			/*여기부터후기*/

		}else if(com.equals("/ParcelOut/reviewWrite.do")){
			command = new Parcel_ReviewWrite_Command();
			command.execute(request, response);
			viewPage = "shareReview.do";
		}else if(com.equals("/ParcelOut/shareReview.do")){
			command = new Parcel_Review_Page_Command();
			command.execute(request, response);
			viewPage = "shareReview.jsp";
		}else if(com.equals("/ParcelOut/reviewPosts.do")){
			command = new Parcel_Review_Posts_Command();
			command.execute(request, response);
			viewPage = "reviewPosts.jsp";
		}else if(com.equals("/ParcelOut/reviewComment.do")){
			command = new Parcel_Review_Comment_Command();
			command.execute(request, response);
			viewPage = "reviewPosts.do";
		}else if(com.equals("/ParcelOut/reviewCommentDelete.do")){
			command = new Parcel_Review_Delete_Comment_Command();
			command.execute(request, response);
			viewPage = "reviewPosts.do";
		}else if(com.equals("/ParcelOut/reviewModifiedSelect.do")){
			command = new Parcel_Review_Modified_Command();
			command.execute(request, response);
			viewPage = "reviewModified.jsp";
		}else if(com.equals("/ParcelOut/reviewUpdateModified.do")){
			command = new Parcel_Review_Insert_Modified_Command();
			command.execute(request, response);
			viewPage = "reviewPosts.do";
		}else if(com.equals("/ParcelOut/reviewDelete.do")){
			command = new Parcel_Review_Delete_Command();
			command.execute(request, response);
			viewPage = "shareReview.do";
		}else if(com.equals("/ParcelOut/reviewSearchList.do")){
			command = new Parcel_Review_Search_Command();
			command.execute(request, response);
			viewPage = "shareReview.jsp";
		}else if(com.equals("/ParcelOut/reviewWriteList.do")){
			command = new Parcel_Review_Write_List_Command();
			command.execute(request, response);
			viewPage = "reviewWrite.jsp";
			
			
			
			
			
			
			//분양 포인트거래
			
			
		}else if(com.equals("/ParcelOut/pointTrade.do")){
			command = new Parcel_Point_Trade_Command();
			command.execute(request, response);
			viewPage = "sharePosts.do";
		}else if(com.equals("/ParcelOut/pointTradeDelete.do")){
			command = new Parcel_Point_Trade_Delete_Command();
			command.execute(request, response);
			viewPage = "sharePosts.do";
		}else if(com.equals("/ParcelOut/pointTradeComplete.do")){
			command = new Parcel_Point_Trade_Complete_Command();
			command.execute(request, response);
			viewPage = "sharePosts.do";
		}
		
		
		
		
		
		
		
		
		
		
		
		if(com.equals("/Market/marketWrite.do")){	//글 쓰기
			command = new MWrite_Commend();
			command.execute(request, response);
			viewPage = "marketList.do";
			
		}else if(com.equals("/Market/marketInsertCart.do")){	//장바구니 담기
			command = new MInsertCart_Commend();
			command.execute(request, response);
			viewPage = "marketCart.do";
			
		}else if(com.equals("/Market/marketCart.do")){	//장바구니 뷰
			command = new MCart_Commend();
			command.execute(request, response);
			viewPage = "marketCart.jsp";
			
		}else if(com.equals("/Market/marketEvaluation.do")){	//댓글 쓰기
			command = new MEvaluation_Commend();
			command.execute(request, response);
			viewPage = "marketMenuDetails.do";
			
		}else if(com.equals("/Market/marketModifiedList.do")){	//수정 뷰
			command = new MModified_Commend();
			command.execute(request, response);
			viewPage = "marketModified.jsp";
			
		}else if(com.equals("/Market/marketModifiedSuccess.do")){	//수정 완료
			command = new MModifiedSuccess_Commend();
			command.execute(request, response);
			viewPage = "marketList.do";
			
		}else if(com.equals("/Market/marketList.do")){	//마켓 메인화면 뷰             ★★★
			command = new MView_Commend();
			command.execute(request, response);
			viewPage = "market.jsp";
			
		}else if(com.equals("/Market/marketMenuDetails.do")){	//마켓 상세메뉴 뷰
			command = new MMenuDetails_Commend();
			command.execute(request, response);
			viewPage = "marketMenuDetails.jsp";
			
		}else if(com.equals("/Market/marketDelete.do")){	//마켓 상품 삭제
			command = new MDelete_Commend();
			command.execute(request, response);
			viewPage = "marketList.do";
		}else if(com.equals("/Market/marketCartDelete.do")){	//장바구니 삭제
			command = new MCartDelete_Commend();
			command.execute(request, response);
			viewPage = "marketCart.do";
		}else if(com.equals("/Market/marketEvaluationDelete.do")){	//댓글 삭제
			command = new MEvaluationDelete_Commend();
			command.execute(request, response);
			viewPage = "marketMenuDetails.do";
		}else if(com.equals("/Market/marketSearch.do")){	//상품검색
			command = new MSearch_Commend();
			command.execute(request, response);
			viewPage = "market.jsp";
		}else if(com.equals("/Market/marketNextPage.do")){
			command = new MNextPage_Commend();
			command.execute(request, response);
			viewPage = "market.jsp";
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);
		
	}


}
