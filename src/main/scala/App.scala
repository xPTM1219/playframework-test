

//package controllers

import javax.inject._
import play.api.mvc._

@Singleton
class HomeController @Inject()(val controllerComponents: ControllerComponents) extends BaseController {

  def hello(name: String) = Action {
    Ok(s"Hello $name! Welcome to Play 2 with Scala 2.")
  }
}

