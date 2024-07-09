from django.urls import path
from . import views

urlpatterns = [
    path('', views.soil_index, name='soils'),
    path('<int:id>/', views.soil_detail, name='soil_detail'),
]
