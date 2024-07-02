from django.urls import path
from . import views

urlpatterns = [
    path('', views.plants_detail, name='single_plant'),
]