/* tslint:disable max-line-length */
import { ComponentFixture, TestBed, async } from '@angular/core/testing';
import { HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';

import { HcPortalTestModule } from '../../../test.module';
import { DiabetesSugarTestDetailComponent } from '../../../../../../main/webapp/app/entities/diabetes-sugar-test/diabetes-sugar-test-detail.component';
import { DiabetesSugarTestService } from '../../../../../../main/webapp/app/entities/diabetes-sugar-test/diabetes-sugar-test.service';
import { DiabetesSugarTest } from '../../../../../../main/webapp/app/entities/diabetes-sugar-test/diabetes-sugar-test.model';

describe('Component Tests', () => {

    describe('DiabetesSugarTest Management Detail Component', () => {
        let comp: DiabetesSugarTestDetailComponent;
        let fixture: ComponentFixture<DiabetesSugarTestDetailComponent>;
        let service: DiabetesSugarTestService;

        beforeEach(async(() => {
            TestBed.configureTestingModule({
                imports: [HcPortalTestModule],
                declarations: [DiabetesSugarTestDetailComponent],
                providers: [
                    DiabetesSugarTestService
                ]
            })
            .overrideTemplate(DiabetesSugarTestDetailComponent, '')
            .compileComponents();
        }));

        beforeEach(() => {
            fixture = TestBed.createComponent(DiabetesSugarTestDetailComponent);
            comp = fixture.componentInstance;
            service = fixture.debugElement.injector.get(DiabetesSugarTestService);
        });

        describe('OnInit', () => {
            it('Should call load all on init', () => {
                // GIVEN

                spyOn(service, 'find').and.returnValue(Observable.of(new HttpResponse({
                    body: new DiabetesSugarTest('123')
                })));

                // WHEN
                comp.ngOnInit();

                // THEN
                expect(service.find).toHaveBeenCalledWith('123');
                expect(comp.diabetesSugarTest).toEqual(jasmine.objectContaining({id: '123'}));
            });
        });
    });

});
