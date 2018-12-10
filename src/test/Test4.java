package test;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JFrame;

import com.teamdev.jxbrowser.chromium.Browser;
import com.teamdev.jxbrowser.chromium.events.FinishLoadingEvent;
import com.teamdev.jxbrowser.chromium.events.LoadAdapter;
import com.teamdev.jxbrowser.chromium.swing.BrowserView;



public class Test4 extends JFrame{
	
	private Browser browser = new Browser();
	private BrowserView browserView = new BrowserView(browser);
	
	public Test4() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setSize(800, 600);
		
		browser.addLoadListener(new LoadAdapter() {
			@Override
			public void onFinishLoadingFrame(FinishLoadingEvent event) {
				if(event.isMainFrame()) {
					System.out.println("HTML 문서가 로드되엇습니다.");
				}
			}
		});
		String title = "하드웨어 판매량";
		ArrayList<Test7> list = new ArrayList<>();
		list.add(new Test7("모니터", 49));
		list.add(new Test7("키보드", 15));
		list.add(new Test7("마우스", 27));
		list.add(new Test7("충전기", 34));
		browser.loadHTML(new Test5().getChart(title, list));
		add(browserView, BorderLayout.CENTER);
	}
}