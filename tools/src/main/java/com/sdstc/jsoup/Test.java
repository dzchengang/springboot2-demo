package com.sdstc.jsoup;

import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;
import org.jsoup.nodes.TextNode;
import org.jsoup.select.Elements;

public class Test {
	public static void main(String[] args) {
		String html = "<p>1</p> "
				      + "<p><span style=\"color: #e03e2d;\">2</span></p> "
				      + "<p>3-1<span style=\"color: #e03e2d;\">3-2</span>3-3</p> "
				      + "<p><span style=\"color: #e03e2d;\">4-1</span>4-2<span style=\"color: #e03e2d;\">4-3</span></p> "
				      + "<p>第三行1<span style=\"color: #e03e2d;\">第三行2 </span><span style=\"color: #e03e2d;\">第三行3<span style=\"color: #b96ad9;\">第三行3-1</span></span></p>";

		Document doc = Jsoup.parse(html);
		Elements elements = doc.select("p");
		for (Element element : elements) {
			parseElement(element);
		}
	}
	
	
	private static void parseElement(Element element) {
		List<Node> childNodes=element.childNodes();
		if(childNodes.size()>0) {
			for(Node childNode:childNodes) {
				if(childNode instanceof Element) {
					parseElement((Element)childNode);
				}else if(childNode instanceof TextNode) {
					childNode.parentNode();
					System.out.println(((TextNode) childNode).text());
				}else {
					System.out.println("---");
				}
			}
		}
	}
	
	private static void parseNode(TextNode node) {
		//获取所在的元素
		Node pNode=node.parentNode();
		if(pNode instanceof Element) {
			Element pElement=(Element) pNode;
		}else {
			System.out.println("---");
		}
	}
	
	
	
}
