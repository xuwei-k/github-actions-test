package controllers

import javax.inject._
import play.api._
import play.api.mvc._

@Singleton
class HomeController @Inject()(val controllerComponents: ControllerComponents) extends BaseController {

  def index = Action { implicit request: Request[AnyContent] =>
    Ok(<html><title>hello</title><body><h1>aaa</h1></body></html>).as("text/html")
  }
}